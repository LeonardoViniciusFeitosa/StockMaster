package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import javax.swing.JLayeredPane;

/**
 * Painel customizado com gradientes variados
 * Permite definir gradientes horizontais, verticais, radiais, circulares ou personalizados
 */
public class PanelGradiente extends JLayeredPane {

    /**
     * Tipos de gradiente disponíveis
     */
    public static enum Gradiente {
        HORIZONTAL, VERTICAL, ESQUINA_1, ESQUINA_2, ESQUINA_3, ESQUINA_4, CIRCULAR, CENTRAL, AQUA;
    }

    // Gradiente atual
    protected Gradiente gradiente = Gradiente.HORIZONTAL;

    // Cores do gradiente
    protected Color primaryColor = Color.WHITE;
    protected Color secondaryColor = Color.WHITE;

    /**
     * Sobrescreve paintComponent para desenhar o gradiente
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();

        // Ativa anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Obtem o Paint de gradiente conforme o tipo definido
        Paint paint = getGradientePaint();
        g2.setPaint(paint);

        // Preenche o painel com o gradiente
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Configura renderização de texto
        g2.setColor(getForeground());
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

        g2.dispose();

        // Mantém o comportamento padrão
        super.paintComponent(graphics);
    }

    /**
     * Retorna o objeto Paint correspondente ao gradiente selecionado
     */
    private Paint getGradientePaint() {
        int x1, y1, x2 = getWidth(), y2 = getHeight();

        switch (this.gradiente) {
            case HORIZONTAL:
                x1 = getWidth() / 2;
                y1 = 0;
                x2 = getWidth() / 2;
                y2 = getHeight();
                return new GradientPaint(x1, y1, primaryColor, x2, y2, secondaryColor);

            case VERTICAL:
                x1 = 0;
                y1 = getHeight() / 2;
                x2 = getWidth();
                y2 = getHeight() / 2;
                return new GradientPaint(x1, y1, primaryColor, x2, y2, secondaryColor);

            case ESQUINA_1:
                x1 = 0; y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{primaryColor, secondaryColor});

            case ESQUINA_2:
                x1 = getWidth(); y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{primaryColor, secondaryColor});

            case ESQUINA_3:
                x1 = getWidth(); y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{primaryColor, secondaryColor});

            case ESQUINA_4:
                x1 = 0; y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{primaryColor, secondaryColor});

            case CIRCULAR:
                x1 = getWidth() / 2; y1 = getHeight() / 2;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 0.5F}, new Color[]{primaryColor, secondaryColor});

            case CENTRAL:
                x1 = getWidth() / 2; y1 = 0;
                x2 = getWidth() / 2; y2 = getHeight();
                return new LinearGradientPaint(x1, y1, x2, y2, new float[]{0.0F, 0.5F, 1.0F}, new Color[]{primaryColor, secondaryColor, primaryColor});

            case AQUA:
                return new LinearGradientPaint(
                        0.0F, 0.0F, 0.0F, getHeight(),
                        new float[]{0.0F, 0.3F, 0.5F, 1.0F},
                        new Color[]{
                                primaryColor.brighter().brighter(),
                                primaryColor.brighter(),
                                secondaryColor.darker().darker(),
                                secondaryColor.darker()
                        });

            default:
                return new GradientPaint(0.0F, 0.0F, primaryColor, x2, y2, secondaryColor);
        }
    }

    // Getters e Setters
    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Gradiente getGradiente() {
        return gradiente;
    }

    public void setGradiente(Gradiente gradiente) {
        this.gradiente = gradiente;
    }
}
