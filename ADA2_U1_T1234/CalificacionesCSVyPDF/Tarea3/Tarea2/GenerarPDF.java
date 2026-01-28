import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.util.*;

public class GenerarPDF {

    public void crearDocumento(String path, ArrayList<String> listaCalificaciones) {
        try {
            // Estructura obligatoria en iText 7
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // título
            document.add(new Paragraph("LISTA DE CALIFICACIONES")
                    .setBold()
                    .setFontSize(18));

            document.add(new Paragraph("\n")); // Espacio

            // Encabezados
            document.add(new Paragraph("Matricula - Nombre Completo: Calificacion")
                    .setBold()
                    .setFontSize(12));

            document.add(new Paragraph("=".repeat(70))); // Línea separadora

            document.add(new Paragraph("\n")); // Espacio

            // Agregar cada calificación
            for (String calificacion : listaCalificaciones) {
                document.add(new Paragraph(calificacion).setFontSize(11));
            }

            document.close();
            System.out.println("PDF (iText 7) generado con exito en: " + path);
        } catch (Exception e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}