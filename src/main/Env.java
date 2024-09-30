package main;

public class Env {
    // Base de datos
    public final static String PATH_DATABASE = "./src/database/";
    public final static String NAME_DATABASE = "data-Course_Stack.db";

    // imagenes
    public final static String PATH_ICON_WINDOW = "src/assets/icon_window.png";
    public final static String PATH_IMAGE_MAIN = "src/assets/main_image.png";
    public final static String PATH_ICON_USER = "src/assets/user_image.png";
    public final static String PATH_ICON_PADLOCK = "src/assets/padlock_image.png";
    public final static String PATH_ICON_UPLOAD = "src/assets/upload_image.png";
    public final static String PATH_ICON_EMAIL = "src/assets/email_image.png";
    public final static String PATH_IMAGE_APPBAR = "src/assets/appbar_image.png";
    public final static String PATH_ICON_HOME = "src/assets/icon_home.png";
    public final static String PATH_ICON_BACK = "src/assets/icon_back.png";
    public final static String PATH_ICON_DROPDOWN = "src/assets/icon_dropdown.png";
    public final static String PATH_ICON_ERROR = "src/assets/Error_icon.png";
    public final static String PATH_ICON_CHECK = "src/assets/Check_icon.png";
    public final static String PATH_ICON_DOWNLOAD = "src/assets/download_imagen.png";

    // Consultas de SQL
    public final static String TYPE_USER_PROPONENT = "Proponente";
    public final static String TYPE_USER_PROPONENT_NATURAL = "Natural";
    public final static String TYPE_USER_PROPONENT_LEGAL = "Jurídico";
    public final static String TYPE_USER_ADMINISTRADOR = "Administrador";
    public final static String QUERY_DATA_TABLE = "PRAGMA table_info(%s)";
    public final static String QUERY_FOREING_KEY_ON = "PRAGMA foreign_keys = ON";
    public final static String QUERY_FOREING_KEY_OFF = "PRAGMA foreign_keys = OF";
    public final static String QUERY_EVALUATE_COURSE_INSERT = "INSERT INTO ResultadosPropuestas(%s)\nVALUES(%s);\n";
    public final static String QUERY_EVALUATE_COURSE_UPDATE = "UPDATE ResultadosPropuestas \r\n"
            + "SET Observaciones = '%s',Resultado = '%s'\r\n" + "WHERE PropuestaID = %s";
    public final static String QUERY_PROPOSAL_PROPONENT = "SELECT * FROM Propuestas WHERE ProponenteID = %s";
    public final static String QUERY_PROPOSAL_ADMINISTRADOR = "SELECT * FROM Propuestas WHERE TipoDeAdministrador = '%s'";
    public final static String QUERY_REGISTER_DOCUMENT = "INSERT INTO DocumentosDeRegistros(%s)\nVALUES(%s);\n";
    public final static String QUERY_REGISTER_USER = "INSERT INTO Proponentes(%s)\nVALUES(%s);\n";
    public final static String QUERY_REGISTER_ADMIN = "INSERT INTO Administradores(%s)\nVALUES(%s);\n";
    public final static String QUERY_LOGIN_PROPONENT = "SELECT * FROM Proponentes WHERE Correo = '%s' and Contraseña = '%s';\n";
    public final static String QUERY_LOGIN_ADMISTRATOR = "SELECT * FROM Administradores WHERE Correo = '%s' and Contraseña = '%s';\n";
    public final static String QUERY_REGISTER_PROPOSAL = "INSERT INTO Propuestas(%s)\nVALUES(%s);";
    public final static String QUERY_VALIDATE_DATA = "SELECT * FROM %s WHERE %s = '%s';\n";
    public final static String CREATE_DATABASE = "DROP TABLE IF EXISTS Proponentes;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS DocumentosDeRegistros;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Administradores;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Propuestas;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Aliados;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS ResultadosPropuestas;\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Proponentes (\r\n" + //
            "        ProponenteID INTEGER PRIMARY KEY,\r\n" + //
            "        Correo TEXT UNIQUE,\r\n" + //
            "        'Contraseña' TEXT,\r\n" + //
            "        TipoDePersona TEXT\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Administradores (\r\n" + //
            "        AdministradorID INTEGER PRIMARY KEY,\r\n" + //
            "        Correo TEXT UNIQUE,\r\n" + //
            "        'Contraseña' TEXT,\r\n" + //
            "        TipoDeAdministrador TEXT\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    DocumentosDeRegistros (\r\n" + //
            "        DocumentosDeRegistrosID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        ProponenteID INTEGER,\r\n" + //
            "        RIF TEXT,\r\n" + //
            "        ISLR TEXT,\r\n" + //
            "        Curriculum TEXT,\r\n" + //
            "        TituloUniversitario TEXT,\r\n" + //
            "        RegistroMercantil TEXT,\r\n" + //
            "        FOREIGN KEY (ProponenteID) REFERENCES Proponentes (ProponenteID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Propuestas (\r\n" + //
            "        PropuestaID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        ProponenteID INTEGER,\r\n" + //
            "        TipoDeAdministrador TEXT,\r\n" + //
            "        Denominacion TEXT,\r\n" + //
            "        ObjetivosYFundamentacion TEXT,\r\n" + //
            "        PerfilDeIngresoYEgreso TEXT,\r\n" + //
            "        PerfilDocente TEXT,\r\n" + //
            "        EstructuraCurricularPorCompetencias TEXT,\r\n" + //
            "        EstrategiasDeEvaluacionYDuracion TEXT,\r\n" + //
            "        ExigenciasEnMaterialesYservicios TEXT,\r\n" + //
            "        EstructuraDeCostos TEXT,\r\n" + //
            "        CronogramaDeEjecucionAnual TEXT,\r\n" + //
            "        UnidadResponsable TEXT,\r\n" + //
            "        FOREIGN KEY (ProponenteID) REFERENCES Proponentes (ProponenteID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    ResultadosPropuestas (\r\n" + //
            "        PropuestaID INTEGER PRIMARY KEY,\r\n" + //
            "        AdministradorID INTEGER,\r\n" + //
            "        Observaciones TEXT,\r\n" + //
            "        Resultado TEXT,\r\n" + //
            "        FOREIGN KEY (PropuestaID) REFERENCES Propuestas (PropuestaID),\r\n" + //
            "        FOREIGN KEY (AdministradorID) REFERENCES Administradores (AdministradorID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Aliados (\r\n" + //
            "        AliadoID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        ProponenteID INTEGER,\r\n" + //
            "        PropuestaID INTEGER,\r\n" + //
            "        CartaDeIntecion TEXT, \r\n" + //
            "        CartaDeCompromiso TEXT,\r\n" + //
            "        CronogramaDeEjecucion TEXT,\r\n" + //
            "        EstructuraDeCostosEingresos TEXT,\r\n" + //
            "        FOREIGN KEY (ProponenteID) REFERENCES Proponentes (ProponenteID),\r\n" + //
            "        FOREIGN KEY (PropuestaID) REFERENCES Propuestas (PropuestaID)\r\n" + //
            "    );";
}
