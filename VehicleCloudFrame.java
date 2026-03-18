import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VehicleCloudFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JRadioButton ownerButton, clientButton, controllerButton;

    private JTextField ownerIDField, vehicleIDField, vehicleModelField,
            vehicleMakeField, vehicleYearField, arrivalTimeField, departureTimeField;

    private JTextField clientIDField, jobIDField, jobDurationField, jobDeadlineField;

    private JTextField controllerJobIDField, redundancyField;

    public VehicleCloudFrame() {
        setupFrame();
        createComponents();
        setVisible(true);
    }

    private void setupFrame() {
        setSize(650, 550);
        setTitle("Vehicular Cloud Real Time System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, int y, String labelText, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridy = y + 1;
        panel.add(field, gbc);
    }

    private boolean isEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void createComponents() {

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // ───── LOGIN  ─────
        JPanel introPanel = new JPanel(new GridBagLayout());
        introPanel.setBackground(new Color(255, 182, 193));

        JPanel loginCard = new JPanel(new GridBagLayout());
        loginCard.setBackground(Color.WHITE);
        loginCard.setPreferredSize(new Dimension(350, 300));
        loginCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbcCard = new GridBagConstraints();
        gbcCard.insets = new Insets(10, 10, 10, 10);
        gbcCard.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Vehicular Cloud System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        gbcCard.gridx = 0; gbcCard.gridy = 0; gbcCard.gridwidth = 2;
        loginCard.add(title, gbcCard);

        JLabel subtitle = new JLabel("Login to Continue", JLabel.CENTER);
        gbcCard.gridy = 1;
        loginCard.add(subtitle, gbcCard);

        gbcCard.gridwidth = 1;

        gbcCard.gridy = 2; gbcCard.gridx = 0;
        loginCard.add(new JLabel("Username"), gbcCard);

        usernameField = new JTextField(20);
        gbcCard.gridx = 1;
        loginCard.add(usernameField, gbcCard);

        gbcCard.gridy = 3; gbcCard.gridx = 0;
        loginCard.add(new JLabel("Password"), gbcCard);

        passwordField = new JPasswordField(20);
        gbcCard.gridx = 1;
        loginCard.add(passwordField, gbcCard);

        JButton loginButton = new JButton("Login");
        gbcCard.gridx = 0; gbcCard.gridy = 4; gbcCard.gridwidth = 2;
        loginCard.add(loginButton, gbcCard);

        introPanel.add(loginCard);

        // ───── HOME ─────
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBackground(new Color(255, 182, 193));

        JLabel homeTitle = new JLabel("Select User Type", JLabel.CENTER);
        homePanel.add(homeTitle, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 182, 193));

        ownerButton = new JRadioButton("Owner");
        clientButton = new JRadioButton("Client");
        controllerButton = new JRadioButton("Controller");

        ButtonGroup group = new ButtonGroup();
        group.add(ownerButton);
        group.add(clientButton);
        group.add(controllerButton);

        buttonPanel.add(ownerButton);
        buttonPanel.add(clientButton);
        buttonPanel.add(controllerButton);

        JButton logoutHome = new JButton("Logout");
        buttonPanel.add(logoutHome);

        homePanel.add(buttonPanel, BorderLayout.CENTER);

        // ───── OWNER PANEL ─────
        JPanel ownerPanel = new JPanel(new GridBagLayout());
        ownerPanel.setBackground(new Color(255, 182, 193));

        GridBagConstraints gbcOwner = new GridBagConstraints();
        gbcOwner.insets = new Insets(8,10,8,10);
        gbcOwner.fill = GridBagConstraints.HORIZONTAL;

        ownerIDField = new JTextField(15);
        vehicleIDField = new JTextField(15);
        vehicleModelField = new JTextField(15);
        vehicleMakeField = new JTextField(15);
        vehicleYearField = new JTextField(15);
        arrivalTimeField = new JTextField(15);
        departureTimeField = new JTextField(15);

        int y = 0;
        addField(ownerPanel, gbcOwner, y, "Owner ID", ownerIDField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Vehicle ID", vehicleIDField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Vehicle Model", vehicleModelField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Vehicle Make", vehicleMakeField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Vehicle Year", vehicleYearField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Arrival Time", arrivalTimeField); y+=2;
        addField(ownerPanel, gbcOwner, y, "Departure Time", departureTimeField); y+=2;

        JButton ownerSubmit = new JButton("Submit");
        gbcOwner.gridy = y++;
        ownerPanel.add(ownerSubmit, gbcOwner);

        JButton logoutOwner = new JButton("Logout");
        gbcOwner.gridy = y;
        ownerPanel.add(logoutOwner, gbcOwner);

        // ───── CLIENT PANEL ─────
        JPanel clientPanel = new JPanel(new GridBagLayout());
        clientPanel.setBackground(new Color(255, 182, 193));

        GridBagConstraints gbcClient = new GridBagConstraints();
        gbcClient.insets = new Insets(8,10,8,10);
        gbcClient.fill = GridBagConstraints.HORIZONTAL;

        clientIDField = new JTextField(15);
        jobIDField = new JTextField(15);
        jobDurationField = new JTextField(15);
        jobDeadlineField = new JTextField(15);

        int y2 = 0;
        addField(clientPanel, gbcClient, y2, "Client ID", clientIDField); y2+=2;
        addField(clientPanel, gbcClient, y2, "Job ID", jobIDField); y2+=2;
        addField(clientPanel, gbcClient, y2, "Job Duration", jobDurationField); y2+=2;
        addField(clientPanel, gbcClient, y2, "Deadline", jobDeadlineField); y2+=2;

        JButton clientSubmit = new JButton("Submit");
        gbcClient.gridy = y2++;
        clientPanel.add(clientSubmit, gbcClient);

        JButton logoutClient = new JButton("Logout");
        gbcClient.gridy = y2;
        clientPanel.add(logoutClient, gbcClient);

        // ───── CONTROLLER PANEL ─────
        JPanel controllerPanel = new JPanel(new GridBagLayout());
        controllerPanel.setBackground(new Color(255, 182, 193));

        GridBagConstraints gbcController = new GridBagConstraints();
        gbcController.insets = new Insets(8,10,8,10);
        gbcController.fill = GridBagConstraints.HORIZONTAL;

        controllerJobIDField = new JTextField(15);
        redundancyField = new JTextField(15);

        int y3 = 0;
        addField(controllerPanel, gbcController, y3, "Job ID", controllerJobIDField); y3+=2;
        addField(controllerPanel, gbcController, y3, "Redundancy", redundancyField); y3+=2;

        JButton computeButton = new JButton("Submit");
        gbcController.gridy = y3++;
        controllerPanel.add(computeButton, gbcController);

        JButton logoutController = new JButton("Logout");
        gbcController.gridy = y3;
        controllerPanel.add(logoutController, gbcController);

        // ───── ADD CARDS ─────
        cards.add(introPanel, "Intro");
        cards.add(homePanel, "Home");
        cards.add(ownerPanel, "Owner");
        cards.add(clientPanel, "Client");
        cards.add(controllerPanel, "Controller");

        add(cards);

        // ───── ACTIONS ─────
        loginButton.addActionListener(e -> cardLayout.show(cards, "Home"));

        ownerButton.addActionListener(e -> cardLayout.show(cards, "Owner"));
        clientButton.addActionListener(e -> cardLayout.show(cards, "Client"));
        controllerButton.addActionListener(e -> cardLayout.show(cards, "Controller"));

        logoutHome.addActionListener(e -> cardLayout.show(cards, "Intro"));
        logoutOwner.addActionListener(e -> cardLayout.show(cards, "Intro"));
        logoutClient.addActionListener(e -> cardLayout.show(cards, "Intro"));
        logoutController.addActionListener(e -> cardLayout.show(cards, "Intro"));

        ownerSubmit.addActionListener(e -> {
            if (isEmpty(ownerIDField, vehicleIDField, vehicleModelField,
                    vehicleMakeField, vehicleYearField, arrivalTimeField, departureTimeField)) {
                JOptionPane.showMessageDialog(this, "Invalid: Enter all required information");
                return;
            }
            JOptionPane.showMessageDialog(this, "Submitted successfully");
        });

        clientSubmit.addActionListener(e -> {
            if (isEmpty(clientIDField, jobIDField, jobDurationField, jobDeadlineField)) {
                JOptionPane.showMessageDialog(this, "Invalid: Enter all required information");
                return;
            }
            JOptionPane.showMessageDialog(this, "Submitted successfully");
        });

        computeButton.addActionListener(e -> {
            if (isEmpty(controllerJobIDField, redundancyField)) {
                JOptionPane.showMessageDialog(this, "Invalid: Enter all required information");
                return;
            }
            JOptionPane.showMessageDialog(this, "Submitted successfully");
        });
    }
}