import main.model.TransformFileBinary;

public class App {
    public static void main(String[] args) throws Exception {
        TransformFileBinary tf = new TransformFileBinary();
        String pdf = tf.transformToBase("src/main/controller/a.txt");

        if (pdf == null)
            return;

        if (pdf.isEmpty()) {
            System.out.println("El archivo esta vacio");
            return;
        }
        byte[] tfp = tf.transformToFile(pdf);

        if (tfp == null) {
            System.out.println("Hubo un problema al guardar el archivo.");
            return;
        }
        tf.saveBytesAsFile(tfp, "./file.txt");
    }

}
