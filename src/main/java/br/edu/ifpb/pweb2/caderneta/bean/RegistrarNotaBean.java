package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.NotaController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Nota;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "regNotaBean")
@ViewScoped
public class RegistrarNotaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Aluno> alunos;
	private Map<Integer, String> alunoNota = new HashMap<Integer, String>();

	@Inject
	private Disciplina disciplina;
	
	@Inject
	private Turma turma;

	@Inject
	private NotaController notaController;

	@Inject
	private AlunoController alunoController;

	@Inject
	private TurmaController turmaController;

	@PostConstruct
	public void init() {
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		if (disciplinaFlash != null) {
			this.disciplina = disciplinaFlash;
			turma = disciplina.getTurma();
			alunos = turma.getAlunos();
		}
	}

	public String registrar() {
		if(turma.getAlunos().isEmpty()) {
			this.KeepMessages();
			this.addInfoMessage("Turma sem alunos!");
			
			return null;
		}
		
		Aluno aluno = null;
		Nota nota = null;
		for (Integer id : alunoNota.keySet()) {
			aluno = alunoController.find(id);
			nota = new Nota(Double.parseDouble(alunoNota.get(id)));
			nota = notaController.insert(nota);
			aluno.add(nota);
			nota.setAluno(aluno);
			nota.setTurma(turma);
			turma.add(nota);

			alunoController.update(aluno);
			notaController.update(nota);
			turmaController.update(turma);
			
			nota = null;
		}
		alunoNota.clear();
		
		this.KeepMessages();
		this.addInfoMessage("Notas registradas com sucesso!");
		
		return "/professor/home?faces-redirect=true";
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Map<Integer, String> getAlunoNota() {
		return alunoNota;
	}

	public void setAlunoNota(Map<Integer, String> alunoNota) {
		this.alunoNota = alunoNota;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
