package semana;

import controller.AdministradorController;
import controller.CursoController;
import controller.EventoController;
import controller.MatriculaController;
import controller.OrganizadorController;
import controller.ParticipanteController;
import controller.PresencaController;
import controller.ResponsavelController;
import controller.SemanaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.Curso;
import model.Evento;
import model.Matricula;
import model.Organizador;
import model.Participante;
import model.Presenca;
import model.Responsavel;
import model.Semana;

public class InitDB {
    private static List<Administrador> administradores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Participante> participantes = new ArrayList<>();
    private static List<Semana> semanas = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Responsavel> responsaveis = new ArrayList<>();
    private static List<Organizador> organizadores = new ArrayList<>();
    private static List<Matricula> matriculas = new ArrayList<>();
    private static List<Presenca> presencas = new ArrayList<>();
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String args[]) {
        initAdministrador();
        initCurso();
        initParticipante(cursos);
        initSemana();
        initEvento();
        initResponsavel();
        initOrganizador();
        initMatricula();
        initPresenca();
    }
    
    private static void initAdministrador() {
        AdministradorController administradorController = new AdministradorController();
        Administrador administrador = new Administrador();
        
        System.out.println("INIT ADMINISTRADOR:");
        
        administrador.setLogin("admin");
        administrador.setSenha("12345");
        administradorController.insert(administrador);
        System.out.println(administrador);
        
        administradores = administradorController.getAll();
    }
    
    private static void initCurso() {
        CursoController cursoController = new CursoController();
        Curso curso = new Curso();
        
        System.out.println("INIT CURSO:");
        
        curso.setSigla("CURC1");
        curso.setNome("Curso 1");
        cursoController.insert(curso);
        System.out.println(curso);
        
        curso.setSigla("CURC2");
        curso.setNome("Curso 2");
        cursoController.insert(curso);
        System.out.println(curso);
        
        cursos = cursoController.getAll();
    }
    
    private static void initParticipante(List<Curso> cursos) {
        ParticipanteController participanteController = new ParticipanteController();
        Participante participante = new Participante();
        
        System.out.println("INIT PARTICIPANTE:");
        
        participante.setProntuario("PE1234567");
        participante.setCurso(cursos.get(0));
        participante.setNome("Participante a");
        participante.setEndereco("Endereco");
        participante.setCidade("Cidade");
        participante.setUf("SP");
        participante.setCep("19470-000");
        participante.setEmail("participante-a@gmail.com");
        participante.setTelefone("(18)91111-1111");
        participante.setCpf("111.111.111-11");
        participante.setLogin("participante-a");
        participante.setSenha("12345");
        participanteController.insert(participante);
        System.out.println(participante);
        
        participante.setProntuario("PE2345678");
        participante.setCurso(cursos.get(0));
        participante.setNome("Participante b");
        participante.setEndereco("Endereco");
        participante.setCidade("Cidade");
        participante.setUf("SP");
        participante.setCep("19470-000");
        participante.setEmail("participante-b@gmail.com");
        participante.setTelefone("(18)92222-2222");
        participante.setCpf("222.222.222-22");
        participante.setLogin("participante-b");
        participante.setSenha("12345");
        participanteController.insert(participante);
        System.out.println(participante);
        
        participante.setProntuario("PE3456789");
        participante.setCurso(cursos.get(1));
        participante.setNome("Participante c");
        participante.setEndereco("Endereco");
        participante.setCidade("Cidade");
        participante.setUf("SP");
        participante.setCep("19470-000");
        participante.setEmail("participante-c@gmail.com");
        participante.setTelefone("(18)93333-3333");
        participante.setCpf("333.333.333-33");
        participante.setLogin("participante-c");
        participante.setSenha("12345");
        participanteController.insert(participante);
        System.out.println(participante);
        
        participante.setProntuario("PE4567890");
        participante.setCurso(cursos.get(1));
        participante.setNome("Participante d");
        participante.setEndereco("Endereco");
        participante.setCidade("Cidade");
        participante.setUf("SP");
        participante.setCep("19470-000");
        participante.setEmail("participante-d@gmail.com");
        participante.setTelefone("(18)94444-4444");
        participante.setCpf("444.444.444-44");
        participante.setLogin("participante-d");
        participante.setSenha("12345");
        participanteController.insert(participante);
        System.out.println(participante);
        
        participantes = participanteController.getAll();
    }
    
    private static void initSemana() {
        SemanaController semanaController = new SemanaController();
        Semana semana = new Semana();
        
        System.out.println("INIT SEMANA:");
        
        semana.setNome("Semana 1");
        semana.setLocal("Local");
        try {
            semana.setInicio(sdf.parse("2024-01-01"));
            semana.setFim(sdf.parse("2024-01-15"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        semana.setObservacao("Observacao");
        semana.setAtiva(false);
        semanaController.insert(semana);
        System.out.println(semana);
        
        semana.setNome("Semana 2");
        semana.setLocal("Local");
        try {
            semana.setInicio(sdf.parse("2024-02-01"));
            semana.setFim(sdf.parse("2024-02-15"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        semana.setObservacao("Observacao");
        semana.setAtiva(true);
        semanaController.insert(semana);
        System.out.println(semana);
        
        semanas = semanaController.getAll();
    }
    
    private static void initEvento() {
        EventoController eventoController = new EventoController();
        Evento evento = new Evento();
        
        System.out.println("INIT EVENTO:");
        
        evento.setSemana(semanas.get(0));
        evento.setTitulo("Evento 1");
        evento.setCargaHoraria(4);
        evento.setNumeroVaga(40);
        evento.setQtdInscrito(0);
        try {
            evento.setDataEvento(sdfh.parse("2024-01-01 14:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        eventoController.insert(evento);
        System.out.println(evento);
        
        evento.setSemana(semanas.get(1));
        evento.setTitulo("Evento 2");
        evento.setCargaHoraria(4);
        evento.setNumeroVaga(40);
        evento.setQtdInscrito(0);
        try {
            evento.setDataEvento(sdfh.parse("2024-02-01 14:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        eventoController.insert(evento);
        System.out.println(evento);
        
        evento.setSemana(semanas.get(1));
        evento.setTitulo("Evento 3");
        evento.setCargaHoraria(4);
        evento.setNumeroVaga(40);
        evento.setQtdInscrito(0);
        try {
            evento.setDataEvento(sdfh.parse("2024-02-01 08:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        eventoController.insert(evento);
        System.out.println(evento);
        
        eventos = eventoController.getAll();
    }
    
    private static void initResponsavel() {
        ResponsavelController responsavelController = new ResponsavelController();
        Responsavel responsavel = new Responsavel();
        
        System.out.println("INIT RESPONSAVEL:");
        
        responsavel.setEvento(eventos.get(0));
        responsavel.setParticipante(participantes.get(0));
        responsavelController.insert(responsavel);
        System.out.println(responsavel);
        
        responsavel.setEvento(eventos.get(1));
        responsavel.setParticipante(participantes.get(0));
        responsavelController.insert(responsavel);
        System.out.println(responsavel);
        
        responsavel.setEvento(eventos.get(2));
        responsavel.setParticipante(participantes.get(0));
        responsavelController.insert(responsavel);
        System.out.println(responsavel);
        
        responsaveis = responsavelController.getAll();
    }
    
    private static void initOrganizador() {
        OrganizadorController organizadorController = new OrganizadorController();
        Organizador organizador = new Organizador();
        
        System.out.println("INIT ORGANIZADOR:");
        
        organizador.setSemana(semanas.get(0));
        organizador.setNome("Organizador a");
        organizador.setCurso(cursos.get(0));
        organizadorController.insert(organizador);
        System.out.println(organizador);
        
        organizador.setSemana(semanas.get(1));
        organizador.setNome("Organizador b");
        organizador.setCurso(cursos.get(1));
        organizadorController.insert(organizador);
        System.out.println(organizador);
        
        organizadores = organizadorController.getAll();
    }
    
    private static void initMatricula() {
        MatriculaController matriculaController = new MatriculaController();
        Matricula matricula = new Matricula();
        
        System.out.println("INIT MATRICULA:");
        
        matricula.setEvento(eventos.get(0));
        matricula.setParticipante(participantes.get(1));
        try {
            matricula.setData(sdf.parse("2024-01-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        matricula.setAtiva(true);
        matriculaController.insert(matricula);
        System.out.println(matricula);
        
        matricula.setEvento(eventos.get(1));
        matricula.setParticipante(participantes.get(1));
        try {
            matricula.setData(sdf.parse("2024-02-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        matricula.setAtiva(true);
        matriculaController.insert(matricula);
        System.out.println(matricula);
        
        matricula.setEvento(eventos.get(2));
        matricula.setParticipante(participantes.get(2));
        try {
            matricula.setData(sdf.parse("2024-02-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        matricula.setAtiva(true);
        matriculaController.insert(matricula);
        System.out.println(matricula);
        
        matriculas = matriculaController.getAll();
    }
    
    private static void initPresenca() {
        PresencaController presencaController = new PresencaController();
        Presenca presenca = new Presenca();
        
        System.out.println("INIT PRESENCA:");
        
        presenca.setMatricula(matriculas.get(0));
        try {
            presenca.setData(sdf.parse("2024-01-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        presenca.setQtdHora(4);
        presencaController.insert(presenca);
        System.out.println(presenca);
        
        presenca.setMatricula(matriculas.get(1));
        try {
            presenca.setData(sdf.parse("2024-02-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        presenca.setQtdHora(4);
        presencaController.insert(presenca);
        System.out.println(presenca);
        
        presenca.setMatricula(matriculas.get(2));
        try {
            presenca.setData(sdf.parse("2024-02-01"));
        } catch (ParseException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        presenca.setQtdHora(4);
        presencaController.insert(presenca);
        System.out.println(presenca);
        
        presencas = presencaController.getAll();
    }
}
