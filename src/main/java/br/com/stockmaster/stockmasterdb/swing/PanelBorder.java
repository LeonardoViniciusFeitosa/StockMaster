package br.com.stockmaster.stockmasterdb.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLayeredPane;

/**
 * Painel customizado com bordas arredondadas
 * Extende JLayeredPane e desenha um fundo arredondado
 */
public class PanelBorder extends JLayeredPane {

    // Raio dos cantos arredondados
    private static final int ARC_RADIUS = 25;

    /**
     * Construtor padrão
     */
    public PanelBorder() {
        // Pode adicionar inicializações futuras se necessário
    }

    /**
     * Sobrescreve o método paintComponent para desenhar bordas arredondadas
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;

        // Ativa anti-aliasing para suavizar as bordas
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor de fundo e preenche o painel com bordas arredondadas
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_RADIUS, ARC_RADIUS);
    }
}
