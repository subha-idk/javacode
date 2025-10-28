package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * A modern Rock-Paper-Scissors game built with Java Swing.
 * This version includes icons, animations, and a reset feature for a
 * full-featured user experience.
 *
 * @author Gemini
 */
public class RockPaperScissorsGUI extends JFrame {

    // Enum for game choices, enhances readability and type safety
    private enum Choice {
        ROCK, PAPER, SCISSORS
    }

    // --- UI Components ---
    private JLabel playerScoreLabel;
    private JLabel computerScoreLabel;
    private JLabel resultLabel;
    private JLabel playerChoiceLabel;
    private JLabel computerChoiceLabel;
    private JButton rockButton, paperButton, scissorsButton, resetButton;

    // --- Icons ---
    private ImageIcon rockIcon, paperIcon, scissorsIcon, questionIcon;

    // --- Game State & Logic ---
    private int playerScore = 0;
    private int computerScore = 0;
    private final Random random = new Random();
    private Timer animationTimer;

    public RockPaperScissorsGUI() {
        // --- 1. Frame Setup ---
        super("Rock Paper Scissors"); // Use super() to set title
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245)); // Light gray background

        // Set a modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and Feel not set: " + e.getMessage());
        }

        // --- 2. Load Resources & Initialize UI ---
        loadIcons();
        initComponents();
    }

    /**
     * Loads all necessary icons from the application's resources.
     * Ensure you have an 'images' folder in your source path.
     */
    private void loadIcons() {
        rockIcon = loadIcon("/images/rock.png", 80);
        paperIcon = loadIcon("/images/paper.png", 80);
        scissorsIcon = loadIcon("/images/scissors.png", 80);
        questionIcon = loadIcon("/images/question.png", 120);
    }

    /**
     * Helper method to load and resize an ImageIcon from the classpath.
     * @param path The path to the image resource (e.g., "/images/rock.png").
     * @param size The desired width and height of the icon.
     * @return The loaded and resized ImageIcon, or null if loading fails.
     */
    private ImageIcon loadIcon(String path, int size) {
        try {
            // getClass().getResource() finds the file within the project's compiled output
            URL url = getClass().getResource(path);
            if (url == null) {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
            BufferedImage image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            System.err.println("Failed to load icon: " + path);
            return null;
        }
    }

    /**
     * Initializes and arranges all UI components.
     */
    private void initComponents() {
        // --- Panels ---
        add(createTopPanel(), BorderLayout.NORTH);
        add(createGamePanel(), BorderLayout.CENTER);
        add(createControlsPanel(), BorderLayout.SOUTH);
    }

    /**
     * Creates the top panel with scores and title.
     */
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        topPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        topPanel.setBackground(new Color(70, 130, 180)); // Steel Blue

        playerScoreLabel = createStyledLabel("Player: 0", Color.WHITE);
        computerScoreLabel = createStyledLabel("Computer: 0", Color.WHITE);

        JLabel titleLabel = createStyledLabel("Rock Paper Scissors", Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));

        topPanel.add(playerScoreLabel);
        topPanel.add(titleLabel);
        topPanel.add(computerScoreLabel);
        return topPanel;
    }

    /**
     * Helper to create styled JLabels for the top panel.
     */
    private JLabel createStyledLabel(String text, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(color);
        return label;
    }

    /**
     * Creates the central game panel showing choices and results.
     */
    private JPanel createGamePanel() {
        JPanel gamePanel = new JPanel(new GridLayout(1, 3, 20, 0));
        gamePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        gamePanel.setOpaque(false);

        playerChoiceLabel = new JLabel(questionIcon);
        playerChoiceLabel.setBorder(BorderFactory.createTitledBorder("Your Choice"));

        computerChoiceLabel = new JLabel(questionIcon);
        computerChoiceLabel.setBorder(BorderFactory.createTitledBorder("Computer's Choice"));

        resultLabel = new JLabel("Choose your move!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));

        gamePanel.add(playerChoiceLabel);
        gamePanel.add(resultLabel);
        gamePanel.add(computerChoiceLabel);
        return gamePanel;
    }

    /**
     * Creates the bottom controls panel with action buttons.
     */
    private JPanel createControlsPanel() {
        JPanel mainControlsPanel = new JPanel(new BorderLayout(10,10));
        mainControlsPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        mainControlsPanel.setOpaque(false);

        JPanel choiceButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        choiceButtonsPanel.setOpaque(false);

        rockButton = createChoiceButton(rockIcon, "Rock", Choice.ROCK);
        paperButton = createChoiceButton(paperIcon, "Paper", Choice.PAPER);
        scissorsButton = createChoiceButton(scissorsIcon, "Scissors", Choice.SCISSORS);

        choiceButtonsPanel.add(rockButton);
        choiceButtonsPanel.add(paperButton);
        choiceButtonsPanel.add(scissorsButton);

        resetButton = new JButton("Reset Game");
        resetButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(e -> resetGame());

        mainControlsPanel.add(choiceButtonsPanel, BorderLayout.CENTER);
        mainControlsPanel.add(resetButton, BorderLayout.EAST);

        return mainControlsPanel;
    }

    /**
     * Helper method to create a styled choice button.
     */
    private JButton createChoiceButton(ImageIcon icon, String tooltip, Choice choice) {
        JButton button = new JButton(icon);
        button.setToolTipText(tooltip);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(e -> startRound(choice));
        return button;
    }

    /**
     * Starts a game round by triggering the animation.
     * @param playerChoice The choice made by the player.
     */
    private void startRound(Choice playerChoice) {
        setButtonsEnabled(false);
        playerChoiceLabel.setIcon(getIconForChoice(playerChoice));
        resultLabel.setText("Computer is thinking...");
        resultLabel.setForeground(Color.BLUE);

        // Determine computer's choice ahead of time
        Choice computerChoice = Choice.values()[random.nextInt(Choice.values().length)];

        // Use a Timer for a delay to create suspense
        animationTimer = new Timer(1500, e -> revealResult(playerChoice, computerChoice));
        animationTimer.setRepeats(false);
        animationTimer.start();
    }

    /**
     * Reveals the result of the round after the animation delay.
     */
    private void revealResult(Choice playerChoice, Choice computerChoice) {
        computerChoiceLabel.setIcon(getIconForChoice(computerChoice));

        if (playerChoice == computerChoice) {
            resultLabel.setText("It's a Tie!");
            resultLabel.setForeground(new Color(255, 140, 0)); // Dark Orange
        } else if (isPlayerWin(playerChoice, computerChoice)) {
            playerScore++;
            resultLabel.setText("You Win!");
            resultLabel.setForeground(new Color(0, 128, 0)); // Dark Green
        } else {
            computerScore++;
            resultLabel.setText("You Lost!");
            resultLabel.setForeground(Color.RED);
        }

        updateScores();
        setButtonsEnabled(true);
    }

    /**
     * Resets the game to its initial state.
     */
    private void resetGame() {
        playerScore = 0;
        computerScore = 0;
        updateScores();
        playerChoiceLabel.setIcon(questionIcon);
        computerChoiceLabel.setIcon(questionIcon);
        resultLabel.setText("Choose your move!");
        resultLabel.setForeground(Color.BLACK);
        setButtonsEnabled(true);
        if(animationTimer != null && animationTimer.isRunning()){
            animationTimer.stop();
        }
    }

    /**
     * Checks the win condition for the player.
     */
    private boolean isPlayerWin(Choice player, Choice computer) {
        return (player == Choice.ROCK && computer ==  Choice.SCISSORS) ||
                (player == Choice.SCISSORS && computer == Choice.PAPER) ||
                (player == Choice.PAPER && computer == Choice.ROCK);
    }

    /**
     * Gets the corresponding icon for a given game choice.
     */
    private ImageIcon getIconForChoice(Choice choice) {
        switch (choice) {
            case ROCK: return rockIcon;
            case PAPER: return paperIcon;
            case SCISSORS: return scissorsIcon;
            default: return questionIcon;
        }
    }

    /**
     * Toggles the enabled state of all choice buttons.
     */
    private void setButtonsEnabled(boolean enabled) {
        rockButton.setEnabled(enabled);
        paperButton.setEnabled(enabled);
        scissorsButton.setEnabled(enabled);
    }

    /**
     * Updates the score display on the UI.
     */
    private void updateScores() {
        playerScoreLabel.setText("Player: " + playerScore);
        computerScoreLabel.setText("Computer: " + computerScore);
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsGUI().setVisible(true));
    }
}

