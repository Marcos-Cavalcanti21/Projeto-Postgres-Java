package SERVICE.CONTROLLER;

import MODEL.Cargo;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.DAO.CargoDAO;
import SERVICE.Get;

import java.sql.*;

public class CargoController {
    public static void InsereCargoController() {
        CargoDAO.InsereCargo();
    }
}
