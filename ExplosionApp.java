import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ExplosionApp extends JPanel implements ActionListener, MouseListener {
    private final ArrayList<Particle> particles = new ArrayList<>();
    private final Timer timer = new Timer(16, this); // ~60 FPS
    private final Random random = new Random();

    public ExplosionApp() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addMouseListener(this);
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Particle Explosion Simulation");
        ExplosionApp app = new ExplosionApp();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(app);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            p.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Iterator<Particle> iterator = particles.iterator();
        while (iterator.hasNext()) {
            Particle p = iterator.next();
            p.update();
            if (p.life <= 0) iterator.remove();
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 100; i++) {
            particles.add(new Particle(e.getX(), e.getY(), random));
        }
    }

    // Unused mouse events
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // Inner Particle class
    private static class Particle {
        double x, y, vx, vy;
        int life;
        Color color;

        public Particle(double x, double y, Random rand) {
            this.x = x;
            this.y = y;
            this.vx = rand.nextDouble() * 4 - 2;
            this.vy = rand.nextDouble() * 4 - 2;
            this.life = 60 + rand.nextInt(40);
            float hue = rand.nextFloat();
            this.color = Color.getHSBColor(hue, 1.0f, 1.0f);
        }

        public void update() {
            x += vx;
            y += vy;
            vy += 0.1; // gravity
            life--;
        }

        public void draw(Graphics g) {
            g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(life * 4, 0)));
            g.fillOval((int)x, (int)y, 5, 5);
        }
    }
}
