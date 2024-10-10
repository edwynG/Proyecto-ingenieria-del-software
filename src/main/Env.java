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

        // expresiones regulares
        public final static String REGEX_EMAIL = "^[#\\w.-_+]+@(.+).com$";
        public final static String REGEX_PASSWORD = "^[#_\\w.+-]{5,20}$";
        public final static String REGEX_DIGI = "^(\\d){5,9}$";


        // Archivos permitidos
        public final static String[] EXTESIONS_NAMES = { "Archivos TXT" };
        public final static String[] EXTESIONS_EXT = { ".txt" };

        // Tipos de admin
        public final static String OUTREACH_COORDINATION = "Coordinación de extensión";
        public final static String OUTREACH_DIRECTORATE = "Dirección de extensión";
        public final static String OUTREACH_COMMITTEE = "Comisión de extensión";
        public final static String FACULTY_COUNCIL = "Consejo de facultad";

        // proponente y admins
        public final static String STATUS_PROPONENT = "Proponente";
        public final static String STATUS_PROPONENTS_ACCEPTED = "Aliado";
        public final static String ACCEPT = "Aprovado";
        public final static String REFUSED = "Desaprovado";
        public final static String WAIT = "En revisión";
        public final static String TYPE_USER_PROPONENT = "Proponente";
        public final static String TYPE_USER_ALIADO = "Aliado";
        public final static String TYPE_USER_PROPONENT_NATURAL = "Natural";
        public final static String TYPE_USER_PROPONENT_LEGAL = "Jurídico";
        public final static String TYPE_USER_ADMINISTRADOR = "Administrador";

        // Opciones de descarga
        public final static String TYPE_UPLOAD_COSTOS = "Costos";
        public final static String TYPE_UPLOAD_SCHEDULE = "Cronograma";
        public final static String TYPE_UPLOAD_LETTER_OF_COMMITENT = "CartaCompromiso";
        public final static String TYPE_UPLOAD_LETTER_OF_INTENT = "cartaDeIntension";
        public final static String TYPE_UPLOAD_OBSERVATIONS = "Observations";
        // Documentos fijos
        public final static String DOCUMENT_LETTER_OF_COMMITMENT = "W05vbWJyZSBkZSBsYSBFbXByZXNhXQpbRGlyZWNjacOzbiBkZSBsYSBFbXByZXNhXQpbQ2l1ZGFkLCBFc3RhZG8sIEPDs2RpZ28gUG9zdGFsXQpbVGVsw6lmb25vXQpbQ29ycmVvIEVsZWN0csOzbmljb10KW0ZlY2hhXQpbTm9tYnJlIGRlbCBFbXBsZWFkb10KW0RpcmVjY2nDs24gZGVsIEVtcGxlYWRvXQpbQ2l1ZGFkLCBFc3RhZG8sIEPDs2RpZ28gUG9zdGFsXQpFc3RpbWFkby9hIFtOb21icmUgZGVsIEVtcGxlYWRvXToKUG9yIG1lZGlvIGRlIGxhIHByZXNlbnRlLCBub3MgY29tcGxhY2UgZm9ybWFsaXphciBlbCBjb21wcm9taXNvIGxhYm9yYWwgcXVlIGhlbW9zIGVzdGFibGVjaWRvIGVudHJlIFtOb21icmUgZGUgbGEgRW1wcmVzYV0geSB1c3RlZC4gRXN0ZSBjb21wcm9taXNvIHJlZmxlamEgbnVlc3RyYSBpbnRlbmNpw7NuIGRlIHRyYWJhamFyIGp1bnRvcyBlbiB1biBhbWJpZW50ZSBkZSByZXNwZXRvLCBwcm9mZXNpb25hbGlzbW8geSBjb2xhYm9yYWNpw7NuLgoxLiBQdWVzdG8gZGUgVHJhYmFqbwpVc3RlZCBvY3VwYXLDoSBlbCBwdWVzdG8gZGUgW1TDrXR1bG8gZGVsIFB1ZXN0b10sIGNvbWVuemFuZG8gZWwgW0ZlY2hhIGRlIEluaWNpb10uIFN1cyByZXNwb25zYWJpbGlkYWRlcyBpbmNsdWlyw6FuLCBwZXJvIG5vIHNlIGxpbWl0YXLDoW4gYSwgW0Rlc2NyaXBjacOzbiBicmV2ZSBkZSBsYXMgcmVzcG9uc2FiaWxpZGFkZXMgZGVsIHB1ZXN0b10uCjIuIENvbXBlbnNhY2nDs24KU3Ugc2FsYXJpbyBzZXLDoSBkZSBbTW9udG9dIFtNb25lZGFdIHBvciBbUGVyaW9kbyBkZSBQYWdvLCBwb3IgZWplbXBsbywgbWVuc3VhbF0sIHkgc2UgbGUgaW5mb3JtYXLDoSBzb2JyZSBsb3MgYmVuZWZpY2lvcyBhZGljaW9uYWxlcyBxdWUgY29ycmVzcG9uZGVuIGEgc3UgcHVlc3RvLgozLiBIb3JhcmlvIExhYm9yYWwKRWwgaG9yYXJpbyBkZSB0cmFiYWpvIHNlcsOhIGRlIFtIb3JhIGRlIEluaWNpb10gYSBbSG9yYSBkZSBGaW5dLCBkZSBbRMOtYXMgZGUgVHJhYmFqb10sIGNvbiB1biBkZXNjYW5zbyBkZSBbRHVyYWNpw7NuIGRlbCBEZXNjYW5zb10uCjQuIFBvbMOtdGljYXMgeSBOb3JtYXRpdmFzCkNvbW8gZW1wbGVhZG8gZGUgW05vbWJyZSBkZSBsYSBFbXByZXNhXSwgc2UgZXNwZXJhIHF1ZSBjdW1wbGEgY29uIGxhcyBwb2zDrXRpY2FzIHkgbm9ybWF0aXZhcyBlc3RhYmxlY2lkYXMgZW4gZWwgbWFudWFsIGRlbCBlbXBsZWFkbywgYXPDrSBjb21vIGNvbiBsb3MgdmFsb3JlcyBkZSBudWVzdHJhIG9yZ2FuaXphY2nDs24uCjUuIER1cmFjacOzbiBkZWwgQ29tcHJvbWlzbwpFc3RlIGNvbXByb21pc28gbGFib3JhbCBzZSBlc3RhYmxlY2UgcG9yIHRpZW1wbyBpbmRlZmluaWRvLCBzdWpldG8gYSBsYXMgY29uZGljaW9uZXMgZGUgZW1wbGVvIHkgZGVzZW1wZcOxbyBxdWUgc2UgZXZhbHVhcsOhbiBkZSBtYW5lcmEgcGVyacOzZGljYS4KQWdyYWRlY2Vtb3Mgc3UgYWNlcHRhY2nDs24geSBjb25maWFuemEgZW4gW05vbWJyZSBkZSBsYSBFbXByZXNhXS4gRXN0YW1vcyBlbnR1c2lhc21hZG9zIHBvciBjb250YXIgY29uIHVzdGVkIGVuIG51ZXN0cm8gZXF1aXBvIHkgY29uZmlhbW9zIGVuIHF1ZSBqdW50b3MgbG9ncmFyZW1vcyBncmFuZGVzIG9iamV0aXZvcy4KUG9yIGZhdm9yLCBmaXJtZSB5IGRldnVlbHZhIHVuYSBjb3BpYSBkZSBlc3RhIGNhcnRhIGNvbW8gY29uZmlybWFjacOzbiBkZSBzdSBhY2VwdGFjacOzbiBkZSBlc3RlIGNvbXByb21pc28gbGFib3JhbC4KQXRlbnRhbWVudGUsCltGaXJtYV0KW05vbWJyZSBkZWwgRmlybWFudGVdCltUw610dWxvIGRlbCBGaXJtYW50ZV0KW05vbWJyZSBkZSBsYSBFbXByZXNhXQpbRmlybWEgZGVsIEVtcGxlYWRvXQpbTm9tYnJlIGRlbCBFbXBsZWFkb10KW0ZlY2hhXQ==";
        // Consultas de SQL
        public final static String TABLE_FIELD_PROPOSAL_ID = "PropuestaID";
        public final static String TABLE_FIELD_EMAIL = "Correo";
        public final static String TABLE_FIELD_ADMINISTRATOR_ID = "AdministradorID";
        public final static String TABLE_FIELD_PROPOENENT_ID = "ProponenteID";
        public final static String TABLE_NAME_ADMINISTRATORS = "Administradores";
        public final static String TABLE_NAME_PROPONENTS = "Proponentes";
        public final static String TABLE_NAME_PROPOSALS = "Propuestas";
        public final static String TABLE_NAME_ALIADO = "Aliados";
        public final static String TABLE_NAME_RESULT_PROPOSAL = "ResultadosPropuestas";
        public final static String QUERY_DATA_TABLE = "PRAGMA table_info(%s)";
        public final static String QUERY_FOREING_KEY_ON = "PRAGMA foreign_keys = ON";
        public final static String QUERY_FOREING_KEY_OFF = "PRAGMA foreign_keys = OF";
        public final static String QUERY_PROPOSAL_WITH_AVAL_ID = "SELECT PropuestaID FROM Aliados WHERE ProponenteID = %s";
        public final static String QUERY_EVALUATE_COURSE_INSERT = "INSERT INTO ResultadosPropuestas(%s)\nVALUES(%s);\n";
        public final static String QUERY_EVALUATE_COURSE_UPDATE = "UPDATE ResultadosPropuestas \r\n"
                        + "SET Observaciones = '%s',Resultado = '%s'\r\n" + "WHERE PropuestaID = %s";
        public final static String QUERY_RESULT_PROPOSAL_RESULT = "SELECT Resultado FROM ResultadosPropuestas WHERE PropuestaID = %s";
        public final static String QUERY_PROPOSAL_PROPOSAL = "SELECT ObjetivosYFundamentacion FROM Propuestas WHERE PropuestaID = %s";
        public final static String QUERY_PROPOSAL_PROBITY = "SELECT PerfilDocente FROM Propuestas WHERE PropuestaID = %s";
        public final static String QUERY_PROPOSAL_CREDENTIAL = "SELECT EstructuraCurricularPorCompetencias FROM Propuestas WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_LETTER_COMMITENT = "UPDATE Propuestas SET CartaDeCompromiso = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_LETTER_INTENT = "UPDATE Propuestas SET CartaDeIntecion = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_COSTOS = "UPDATE Aliados SET EstructuraDeCostosEingresos = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_OBSERVATIONS = "UPDATE ResultadosPropuestas SET Observaciones = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_EVALUATION_PROPOSAL = "UPDATE ResultadosPropuestas SET Resultado = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_UPDATE_SCHEDULE = "UPDATE Aliados SET CronogramaDeEjecucion = '%s' WHERE PropuestaID = %s";
        public final static String QUERY_PROPOSAL_PROPONENT = "SELECT * FROM Propuestas WHERE ProponenteID = %s";
        public final static String QUERY_PROPOSAL_ADMINISTRADOR = "SELECT * FROM Propuestas WHERE UnidadResponsable = '%s'";
        public final static String QUERY_RESULT_PROPOSAL = "SELECT * FROM ResultadosPropuestas WHERE PropuestaID = %s";
        public final static String QUERY_PROPOSAL_EVALUATE_FOR_ADMIN = "SELECT * FROM ResultadosPropuestas WHERE PropuestaID = %s and AdministradorID = %s;";
        public final static String QUERY_REGISTER_DOCUMENT_NATURAL = "INSERT INTO DocumentosDeRegistros(ProponenteID,RIF,ISLR,Curriculum,TituloUniversitario)\nVALUES(%s);\n";
        public final static String QUERY_REGISTER_RESULT_PROPOSAL = "INSERT INTO ResultadosPropuestas(PropuestaID,AdministradorID)\nVALUES(%s,%s)";
        public final static String QUERY_DELETE_ALIADO = "DELETE FROM Aliados\nWHERE PropuestaID = %s";
        public final static String QUERY_CREATE_ALIADO = "INSERT INTO Aliados(ProponenteID,PropuestaID)\nVALUES(%s,%s)";
        public final static String QUERY_REGISTER_DOCUMENT_LEGAL = "INSERT INTO DocumentosDeRegistros(ProponenteID,RIF,ISLR,Curriculum,TituloUniversitario,RegistroMercantil)\nVALUES(%s);\n";
        public final static String QUERY_REGISTER_USER = "INSERT INTO Proponentes(ProponenteID,Correo,Contraseña,TipoDePersona)\nVALUES(%s, '%s', '%s','%s');\n";
        public final static String QUERY_REGISTER_ADMIN = "UPDATE Administradores SET Contraseña = %s\nWHERE Correo = '%s' ";
        public final static String QUERY_LOGIN_PROPONENT = "SELECT * FROM Proponentes WHERE Correo = '%s' and Contraseña = '%s';\n";
        public final static String QUERY_LOGIN_ADMISTRATOR = "SELECT * FROM Administradores WHERE Correo = '%s' and Contraseña = '%s';\n";
        public final static String QUERY_REGISTER_PROPOSAL = "INSERT INTO Propuestas(ProponenteID, Titulo, Denominacion, ObjetivosYFundamentacion,PerfilDeIngresoYEgreso,PerfilDocente, EstructuraCurricularPorCompetencias, EstrategiasDeEvaluacionYDuracion, ExigenciasEnMaterialesYservicios, EstructuraDeCostos, CronogramaDeEjecucionAnual, UnidadResponsable)\nVALUES(%s);";
        public final static String QUERY_VALIDATE_DATA = "SELECT * FROM %s WHERE %s = %s;\n";
        // Consulta para crear la base de datos;
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
                                "        Unidad TEXT\r\n" + //
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
                                "        Titulo TEXT,\r\n" + //
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
                                "        CartaDeIntecion TEXT,\r\n" + //
                                "        CartaDeCompromiso TEXT,\r\n" + //
                                "        FOREIGN KEY (ProponenteID) REFERENCES Proponentes (ProponenteID)\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "CREATE TABLE\r\n" + //
                                "    ResultadosPropuestas (\r\n" + //
                                "        ResultadosPropuestasID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
                                "        PropuestaID INTEGER,\r\n" + //
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
                                "        CronogramaDeEjecucion TEXT,\r\n" + //
                                "        EstructuraDeCostosEingresos TEXT,\r\n" + //
                                "        FOREIGN KEY (ProponenteID) REFERENCES Proponentes (ProponenteID),\r\n" + //
                                "        FOREIGN KEY (PropuestaID) REFERENCES Propuestas (PropuestaID)\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "INSERT INTO\r\n" + //
                                "    Administradores (AdministradorID, Correo, Unidad)\r\n" + //
                                "VALUES\r\n" + //
                                "    (\r\n" + //
                                "        30326271,\r\n" + //
                                "        'edwynjesus30@gmail.com',\r\n" + //
                                "        'Consejo de facultad'\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "INSERT INTO\r\n" + //
                                "    Administradores (AdministradorID, Correo, Unidad)\r\n" + //
                                "VALUES\r\n" + //
                                "    (\r\n" + //
                                "        30326278,\r\n" + //
                                "        'juandavid2002111@gmail.com',\r\n" + //
                                "        'Consejo de facultad'\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "INSERT INTO\r\n" + //
                                "    Administradores (AdministradorID, Correo, Unidad)\r\n" + //
                                "VALUES\r\n" + //
                                "    (\r\n" + //
                                "        30326279,\r\n" + //
                                "        'uzcasimon@gmail.com',\r\n" + //
                                "        'Coordinación de extensión'\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "INSERT INTO\r\n" + //
                                "    Administradores (AdministradorID, Correo, Unidad)\r\n" + //
                                "VALUES\r\n" + //
                                "    (\r\n" + //
                                "        30326273,\r\n" + //
                                "        'diegoaherediaruni@gmail.com',\r\n" + //
                                "        'Dirección de extensión'\r\n" + //
                                "    );\r\n" + //
                                "\r\n" + //
                                "INSERT INTO\r\n" + //
                                "    Administradores (AdministradorID, Correo, Unidad)\r\n" + //
                                "VALUES\r\n" + //
                                "    (\r\n" + //
                                "        30326274,\r\n" + //
                                "        'patydanicc@gmail.com',\r\n" + //
                                "        'Comisión de extensión'\r\n" + //
                                "    );";
}
