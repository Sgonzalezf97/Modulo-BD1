package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.HorasDirector;
import com.unidad.deportiva.modulo.utilities.ConexionOracle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class HorasDirectorDAO {

    private ConexionOracle cn;

    private ResultSet rs;

    Logger logger = LoggerFactory.getLogger(HorasDirectorDAO.class);

    public HorasDirectorDAO() throws Exception {
        try {
            cn = new ConexionOracle();

        }catch (Exception e){
            logger.error("Error conexion");
        }

    }

    public ArrayList<HorasDirector> consultaPDFPasantes(){

        ArrayList<HorasDirector> horasPasantes = null;

        try {
            PreparedStatement preparedStatement = cn.getConexion().prepareStatement
                    ("SELECT SUM(to_number(to_char((To_date(P.IDHORA, 'HH24:MI')), 'HH24'))) AS \"HorasTotal\", E.NOMESTU AS \"NombrePasante\", P.IDPERIODO AS \"Periodo\", ES.NOMESPACIO AS \"Sede\" \n" +
                            "FROM ESTUDIANTE E, RESPONSABLE R, PROGRAMACION P, ASISTIRRESPONSABLE A, ESPACIO ES\n" +
                            "WHERE E.CODESTUDIANTE=R.CODESTUDIANTE AND R.CONSECRES=A.CONSECRES AND R.IDACTIVIDAD=A.IDACTIVIDAD \n" +
                            "AND R.CONSECPROGRA=A.CONSECPROGRA AND P.IDACTIVIDAD=R.IDACTIVIDAD \n" +
                            "AND P.CONSECPROGRA=R.CONSECPROGRA AND ES.CODESPACIO=E.CODESPACIO\n" +
                            "GROUP BY E.NOMESTU, P.IDPERIODO, ES.NOMESPACIO, E.CODESTUDIANTE");

            rs = preparedStatement.executeQuery();
            logger.info("Supera RS");

            horasPasantes = new ArrayList<>();

            while (rs.next()){

                HorasDirector horasPasante = new HorasDirector();

                horasPasante.setHoras(rs.getLong("HorasTotal"));
                horasPasante.setNombre(rs.getString("NombrePasante"));
                horasPasante.setPeriodo(rs.getString("Periodo"));
                horasPasante.setSede(rs.getString("Sede"));

                horasPasantes.add(horasPasante);
            }

            preparedStatement.executeUpdate();
            logger.info("Success consulta");
        }catch (SQLException e){
            logger.info("Error consulta dentro de DAO");
            logger.error(e.getSQLState());
        }

        return horasPasantes;
    }


    public ArrayList<HorasDirector> consultaPDFMiembros(){

        ArrayList<HorasDirector> horasPasantes = null;

        try {
            PreparedStatement preparedStatement = cn.getConexion().prepareStatement
                    ("SELECT SUM(to_number(to_char((To_date(P.IDHORA, 'HH24:MI')), 'HH24'))) AS \"Horastotal\", E.NOMESTU AS \"NombrePasante\", P.IDPERIODO AS \"Periodo\", ES.NOMESPACIO AS \"Sede\" \n" +
                            "FROM ESTUDIANTE E, MIEMBROEQUIPO ME, ASISMIEMBROEQUIPO AME, PROGRAMACION P, ESPACIO ES, EQUIPO EQ\n" +
                            "WHERE ES.CODESPACIO=E.CODESPACIO AND E.CODESTUDIANTE=ME.CODESTUDIANTE AND ME.CONSECEQUIPO=AME.CONSECEQUIPO AND P.IDACTIVIDAD=AME.IDACTIVIDAD \n" +
                            "AND P.CONSECPROGRA=AME.CONSECPROGRA AND EQ.CONSECEQUIPO=ME.CONSECEQUIPO\n" +
                            "GROUP BY E.NOMESTU, P.IDPERIODO, ES.NOMESPACIO");

            rs = preparedStatement.executeQuery();
            logger.info("Supera RS");

            horasPasantes = new ArrayList<>();

            while (rs.next()){

                HorasDirector horasPasante = new HorasDirector();

                horasPasante.setHoras(rs.getLong("HorasTotal"));
                horasPasante.setNombre(rs.getString("NombrePasante"));
                horasPasante.setPeriodo(rs.getString("Periodo"));
                horasPasante.setSede(rs.getString("Sede"));

                horasPasantes.add(horasPasante);
            }

            preparedStatement.executeUpdate();
            logger.info("Success consulta");
        }catch (SQLException e){
            logger.info("Error consulta dentro de DAO");
            logger.error(e.getSQLState());
        }

        return horasPasantes;
    }


}
