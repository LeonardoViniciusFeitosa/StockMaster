package swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Painel customizado para animação de transição entre componentes (slide)
 * Permite adicionar múltiplos componentes e alternar entre eles com animação horizontal
 */
public class PanelSlide extends JPanel {

    // Velocidade da animação em pixels
    private int animateSpeed = 1;

    // Timer para animação
    private Timer timer;

    // Componentes envolvidos na animação atual
    private Component currentComponent;
    private Component nextComponent;

    // Lista de todos os componentes adicionados
    private final List<Component> componentList = new ArrayList<>();

    // Índice do componente atualmente visível
    private int currentShowing = 0;

    // Indica a direção da animação (true = direita para esquerda)
    private boolean animateRight;

    /**
     * Construtor do painel
     * Inicializa o Timer que dispara a animação
     */
    public PanelSlide() {
        initComponents();
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });
    }

    // Getter e Setter da velocidade da animação
    public int getAnimateSpeed() {
        return animateSpeed;
    }

    public void setAnimateSpeed(int animateSpeed) {
        this.animateSpeed = animateSpeed;
    }

    /**
     * Inicializa o painel com os componentes que participarão do slide
     * @param components componentes a serem adicionados ao painel
     */
    public void init(Component... components) {
        if (components.length > 0) {
            for (Component c : components) {
                componentList.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }
            Component show = componentList.get(0);
            show.setVisible(true);
            show.setLocation(0, 0);
        }
    }

    /**
     * Exibe o componente com o índice informado e anima a transição
     * @param index índice do componente a ser exibido
     */
    public void show(int index) {
        if (!timer.isRunning() && componentList.size() >= 2
                && index < componentList.size() && index != currentShowing) {

            nextComponent = componentList.get(index);
            currentComponent = componentList.get(currentShowing);

            animateRight = index < currentShowing;
            currentShowing = index;

            nextComponent.setVisible(true);
            nextComponent.setLocation(animateRight ? -nextComponent.getWidth() : getWidth(), 0);

            timer.start();
        }
    }

    /**
     * Executa a animação de transição entre componentes
     */
    private void animate() {
        if (animateRight) {
            if (nextComponent.getLocation().x < 0) {
                nextComponent.setLocation(nextComponent.getLocation().x + animateSpeed, 0);
                currentComponent.setLocation(currentComponent.getLocation().x + animateSpeed, 0);
            } else {
                nextComponent.setLocation(0, 0);
                timer.stop();
                currentComponent.setVisible(false);
            }
        } else {
            if (nextComponent.getLocation().x > 0) {
                nextComponent.setLocation(nextComponent.getLocation().x - animateSpeed, 0);
                currentComponent.setLocation(currentComponent.getLocation().x - animateSpeed, 0);
            } else {
                nextComponent.setLocation(0, 0);
                timer.stop();
                currentComponent.setVisible(false);
            }
        }
    }

    /**
     * Código gerado pelo NetBeans para inicializar o layout do painel
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
    }
}
