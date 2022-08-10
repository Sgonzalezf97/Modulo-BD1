package com.unidad.deportiva.modulo.controllers;

import com.unidad.deportiva.modulo.models.*;
import com.unidad.deportiva.modulo.repository.HorasDirectorDAO;
import com.unidad.deportiva.modulo.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AuxiliarController {

    @Autowired
    EmpleadoCargoService empleadoCargoService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    CargoService cargoService;
    @Autowired
    EspacioService espacioService;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    MiembroEquipoService miembroEquipoService;

    @Autowired
    ActividadService actividadService;

    @Autowired
    DeporteService deporteService;

    @Autowired
    ResponsableService responsableService;

    @Autowired
    ProgramacionService programacionService;

    @Autowired
    AsistirResponsaleService asistirResponsaleService;

    @Autowired
    ElemenDeportivoService elemenDeportivoService;

    @Autowired
    LoginService loginService;

    Logger logger = LoggerFactory.getLogger(AuxiliarController.class);

    @GetMapping("/auxiliar")
    public String indexAuxiliar(Model model) {



        Empleado empleado = LoginSingleton.getService().getEmpleado();
        Cargo cargo = LoginSingleton.getService().getCargo();
        List<Espacio> espacios = LoginSingleton.getService().getEspacio();

        model.addAttribute("standardDate", new Date());
        model.addAttribute("espacios", espacios);
        model.addAttribute("cargo", cargo);
        model.addAttribute("empleado", empleado);
        return "auxiliar";
    }

    @GetMapping({"/consultaDocente"})
    public String consultarDocente(Model model){
        model.addAttribute("empleado", new Empleado());
        return "consultaDocente";
    }

    @PostMapping({"/consultaDocente"})
    public String consultarDocente(Model model, Empleado empleado){

        Empleado empleadoResponse = empleadoService.findDocente(empleado.getNomEmpleado().toLowerCase(), empleado.getApellEmpleado().toLowerCase());

        if(empleadoResponse == null){
            logger.info("Docente no encontrado");
            return "redirect:/consultaDocente";
        }else{

            logger.info("Docente encontrado");
            logger.info("Buscando IDCARGO");
            Empleado_Cargo empleado_cargo = empleadoCargoService.findByCodEmpleado(empleadoResponse.getCodEmpleado());
            logger.info("Buscando cargo");
            Cargo cargo = cargoService.findById(Long.valueOf(empleado_cargo.getIdCargo()));
            logger.info("Buscando espacios");
            List<Espacio> espacios = espacioService.findById(empleado_cargo.getCodEmpleado());

            loginService.iniciarSesion(empleado, cargo, espacios);
            return "redirect:/docenteElementos";
        }

    }

    @GetMapping({"/docenteElementos"})
    public String docenteElementos(Model model){

        //Consulta horarios
        logger.info("Buscando actividad");
        List<Actividad> actividades = actividadService.findAll();
        logger.info("Buscando espacio");
        List<Espacio> espacios = espacioService.findAll();
        logger.info("Buscando deporte");
        List<Deporte> deportes = deporteService.findAll();
        logger.info("Buscando empleado");
        List<Empleado> empleados = empleadoService.findAll();
        logger.info("Buscando responsable");
        List<Responsable> responsables = responsableService.findAll();
        logger.info("Buscando programaciones");
        List<Programacion> programaciones = programacionService.findAll();


        if(actividades == null){
            logger.info("Actividad no encontrada");
        } else if (espacios == null) {
            logger.info("Espacio no encontrada");
        }else if(deportes == null) {
            logger.info("Deport no encontrada");
        }else if(empleados == null) {
            logger.info("EMPLEADO no encontrada");
        }else if(deportes == null) {
            logger.info("DEPORTES no encontrada");
        }else if(responsables == null) {
            logger.info("RESPONSABLE no encontrada");
        }else if(programaciones == null) {
            logger.info("PROGRAMACIONES no encontrada");
        }

        logger.info("Encuentra entidades");

        ArrayList<RangoHora> rangoHoras = new ArrayList<>();

        List<ElemenDeportivo> elemenDeportivos = elemenDeportivoService.findAll();

        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);

        logger.info("Hora con hour" + String.valueOf(hour));

        Calendar date2 = Calendar.getInstance();
        int dia = date2.get(Calendar.DAY_OF_WEEK);

        logger.info("Dia de la semana:" + String.valueOf(dia));


        for(Actividad actividad : actividades){
            for (Espacio espacio : espacios){
                for (Deporte deporte : deportes){
                    for (Empleado empleado : empleados){
                        for (Responsable responsable : responsables){
                            for (Programacion programacion : programaciones){
                                if(espacio.getCodEspacio().equalsIgnoreCase(programacion.getCodEspacio())){
                                    if(empleado.getCodEmpleado().equalsIgnoreCase(responsable.getCodEmpleado())){
                                        if (programacion.getConsecProgra().equals(responsable.getConsecProgra())){
                                            if(programacion.getIdActividad().equalsIgnoreCase("CU")) {
                                                if(programacion.getIdActividad().equalsIgnoreCase(actividad.getIdActividad())) {
                                                    if(programacion.getIdDeporte().equalsIgnoreCase(deporte.getIdDeporte())) {
                                                        if (hour >= (Integer.parseInt((programacion.getIdHora()).substring(0,2))) && hour <= (Integer.parseInt((programacion.getHor_idHora()).substring(0,2)))) {
                                                            if ((String.valueOf(dia-1)).equalsIgnoreCase(programacion.getIdDia())) {
                                                                if(LoginSingleton.getService().getEmpleado().getNomEmpleado().equalsIgnoreCase(empleado.getNomEmpleado())) {
                                                                    if(LoginSingleton.getService().getEmpleado().getNomEmpleado().equalsIgnoreCase(empleado.getApellEmpleado())) {
                                                                        RangoHora rangoHora = new RangoHora();
                                                                        rangoHora.setId(empleado.getCodEmpleado());
                                                                        rangoHora.setCurso(deporte.getIdDeporte());
                                                                        rangoHora.setNomDeporte(deporte.getNomDeporte());
                                                                        rangoHora.setEspacio(espacio.getCodEspacio());
                                                                        rangoHora.setEspacio(espacio.getNomEspacio());
                                                                        rangoHora.setInscritos(programacion.getNoInscrito());
                                                                        rangoHoras.add(rangoHora);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        ArrayList<ElemenDeportivo> elmentosClase = new ArrayList<>();

        for (ElemenDeportivo elemenDeportivo: elemenDeportivos){
            for(RangoHora rango: rangoHoras){
                if(elemenDeportivo.getCodEspacio().equalsIgnoreCase(rango.getCodEspacio())){
                    ElemenDeportivo elementosFinales = new ElemenDeportivo();
                    elementosFinales.setConsecPogram(elemenDeportivo.getConsecPogram());
                    elementosFinales.setIdTipoElemento(elemenDeportivo.getIdTipoElemento());
                    elementosFinales.setIdEstado(elemenDeportivo.getIdEstado());
                    elementosFinales.setIdMarca(elemenDeportivo.getIdMarca());
                    elementosFinales.setFechaRegistro(elemenDeportivo.getFechaRegistro());
                    elmentosClase.add(elementosFinales);
                }
            }
        }

        logger.info(Arrays.toString(rangoHoras.toArray()));

        model.addAttribute("elementos", elmentosClase);
        model.addAttribute("rangoHoras", rangoHoras);
        return "docenteElementos";
    }

    @GetMapping({"/consultaEstudiante"})
    public String consultaEstudiante(Model model){
        model.addAttribute("estudiante", new Estudiante() );
        return "consultaEstudiante";
    }

    @PostMapping({"/consultaEstudiante"})
    public String consultaEstudiante(Model model, Estudiante estudiante){

        Estudiante estudianteResponse = estudianteService.findByCodEstudiante(estudiante.getCodEstudiante());

        if(estudianteResponse == null){
            return "redirect:/consultaEstudiante";
        }else{

            return "redirect:/consultaEstudiante";
        }

    }

    @GetMapping({"/consultaMiembroEquipo"})
    public String consultaMiembroEquipo(Model model){
        model.addAttribute("miembroEquipo", new MiembroEquipo());
        return "consultaMiembroEquipo";
    }

    @PostMapping({"/consultaMiembroEquipo"})
    public String consultaMiembroEquipo(Model model, MiembroEquipo miembroEquipo){

        MiembroEquipo miembroEquipoResponse = miembroEquipoService.findByCodEstudianteAndEquipo(miembroEquipo.getCodEstudiante(), miembroEquipo.getConsecEquipo());

        if(miembroEquipoResponse == null){
            return "redirect:/consultaMiembroEquipo";
        }else{

            return "redirect:/consultaMiembroEquipo";
        }

    }

    @GetMapping({"/insertarAsistencia"})
    public String insertarAsistencia(Model model){
        model.addAttribute("responsable", new AsistirResponsable());
        return "insertarAsistencia";
    }

    @PostMapping({"/insertarAsistencia"})
    public String insertarAsistencia(Model model, @ModelAttribute AsistirResponsable responsable) throws ParseException {

        Empleado empleado = LoginSingleton.getService().getEmpleado();
        Responsable responsableResponse = responsableService.findByCodEmpleado(empleado.getCodEmpleado());

        Calendar now = Calendar.getInstance();
        Integer hour = now.get(Calendar.HOUR_OF_DAY);

        SimpleDateFormat originalFormat = new SimpleDateFormat("HH");
        Date date = originalFormat.parse(hour.toString());
        logger.info("La hora es: " + hour);
        responsable.setConsecProgra(responsableResponse.getConsecProgra());
        responsable.setIdActividad("CU");
        responsable.setConsecRes(responsableResponse.getConsecRes());
        responsable.setHoraAsisRes(date);

        logger.info(responsable.toString());
        asistirResponsaleService.save(responsable);


        return "redirect:/login";
    }

    @GetMapping({"/prestamo"})
    public String prestamo(Model model){
        model.addAttribute("miembroEquipo", new Prestamo());
        return "prestamo";
    }

    @PostMapping({"/prestamo"})
    public String prestamo(Model model, MiembroEquipo miembroEquipo){

        return "prestamo";

    }

}
