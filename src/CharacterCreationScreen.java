import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CharacterCreationScreen extends JPanel {
    private JButton startBattleButton;
    private JButton reRollButton;
    private JTextField characterName;
    private JTextArea characterInfo;
    private JTextField hpField;
    private JTextField defenseField;
    private JTextField agilityField;
    private JTextField baseAttackField;
    private JTextField weightField;
    private JTextField attackModifierField;
    private JLabel charImageLabel;
    private JLabel weaponImageLabel;
    private JTextArea weaponInfo;

    public CharacterCreationScreen() {
        //screen size
        this.setBounds(0, 0, 800, 800);
        this.setBackground(new Color(194, 235, 91));
        this.setLayout(null);
        this.setVisible(true);

        JLabel infoLabel = new JLabel("Character Generator");
        infoLabel.setBounds(250, 30, 400, 50);
        //set font just for title
        infoLabel.setFont(new Font ("Engravers Old English",Font.BOLD,35));
        this.add(infoLabel);

        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(30, 100, 100, 20);
        this.add(nameLabel);

        characterName = new JTextField(); //one line control
        characterName.setBounds(nameLabel.getX() + nameLabel.getWidth() + 10, nameLabel.getY(), 200, 20);
        // Adjusted position so label is next to textField
        this.add(characterName);

        JLabel typeLabel = new JLabel("Character Type:");
        typeLabel.setBounds(30, 160, 100, 20);
        this.add(typeLabel);

        JLabel statsLabel = new JLabel("Character Stats:");
        statsLabel.setBounds(530, 100, 100, 20);
        this.add(statsLabel);

        //display info about character
        characterInfo = new JTextArea(); //multi line control
        characterInfo.setBounds(30, 340, 300, 80);
        characterInfo.setLineWrap(true); // Enable word wrap
        characterInfo.setWrapStyleWord(true); // Wrap at word boundaries
        this.add(characterInfo);

        //character image
        charImageLabel = new JLabel("Select a Class");
        charImageLabel.setBounds(200, 180, 135, 135);
        ImageIcon charImage = new ImageIcon(getClass().getResource("placeholder.jpg"));
        charImageLabel.setIcon(charImage);//set image to the icon
        this.add(charImageLabel);

        //stats fields

        JLabel hpLabel = new JLabel("Hit Points");
        hpLabel.setBounds(530, 160, 100, 20);
        this.add(hpLabel);

        hpField = new JTextField();
        hpField.setBounds(660, 160, 50, 20);
        this.add(hpField);

        JLabel defenseLabel = new JLabel("Defence");
        defenseLabel.setBounds(530, 200, 100, 20);
        this.add(defenseLabel);

        defenseField = new JTextField();
        defenseField.setBounds(660, 200, 50, 20);
        this.add(defenseField);

        JLabel agilityLabel = new JLabel("Agility");
        agilityLabel.setBounds(530, 240, 100, 20);
        this.add(agilityLabel);

        agilityField = new JTextField();
        agilityField.setBounds(660, 240, 50, 20);
        this.add(agilityField);

        JLabel baseAttackLabel = new JLabel("Base Attack");
        baseAttackLabel.setBounds(530, 280, 100, 20);
        this.add(baseAttackLabel);

        baseAttackField = new JTextField();
        baseAttackField.setBounds(660, 280, 50, 20);
        this.add(baseAttackField);


        //player radio buttons
        ArrayList<Player> players = ProgramWindow.getPlayerList();
        int yPosition = 200;
        ButtonGroup playerSelection = new ButtonGroup();
        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            JRadioButton currentPlayerRadio = new JRadioButton(currentPlayer.getClass().getSimpleName());//had to google how to get the name.
            currentPlayerRadio.setBounds(30, yPosition, 150, 50);
            int finalI = i;
            currentPlayerRadio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //set all characteristics about selected player
                    ProgramWindow.setSelectedPlayer(finalI);
                    characterInfo.setText(currentPlayer.giveDescription());
                    String imagePath = currentPlayer.getClass().getSimpleName() + ".jpg";
                    ImageIcon playerImage = new ImageIcon(getClass().getResource(imagePath));
                    charImageLabel.setIcon(playerImage);
                    hpField.setText(String.valueOf(currentPlayer.getHp()));
                    defenseField.setText(String.valueOf(currentPlayer.getDefence()));
                    agilityField.setText(String.valueOf(currentPlayer.getAgility()));
                    baseAttackField.setText(String.valueOf(currentPlayer.getBaseAttack()));

                }
            });
            playerSelection.add(currentPlayerRadio);
            this.add(currentPlayerRadio);
            yPosition += 40;
        }

        JLabel weaponLabel = new JLabel("Select your Weapon:");
        weaponLabel.setBounds(30, 440, 400, 20);
        this.add(weaponLabel);

        //weapon image
        weaponImageLabel = new JLabel("Select a Weapon");
        weaponImageLabel.setBounds(200, 460, 135, 135);
        ImageIcon weaponImage = new ImageIcon(getClass().getResource("placeholder.jpg"));
        weaponImageLabel.setIcon(weaponImage);//set image to the icon
        this.add(weaponImageLabel);

        //display info about weapon
        weaponInfo = new JTextArea();
        weaponInfo.setBounds(30, 620, 300, 120);
        weaponInfo.setLineWrap(true); // Enable word wrap
        weaponInfo.setWrapStyleWord(true); // Wrap at word boundaries
        this.add(weaponInfo);

        //weapon stats *need to be declared before use in weapon radio buttons

        JLabel attackModifierLabel = new JLabel("Attack Modifier");
        attackModifierLabel.setBounds(530, 500, 100, 20);
        this.add(attackModifierLabel);

        attackModifierField = new JTextField();
        attackModifierField.setBounds(660, 500, 50, 20);
        this.add(attackModifierField);

        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setBounds(530, 540, 100, 20);
        this.add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(660, 540, 50, 20);
        this.add(weightField);


        //weapon radio buttons
        ArrayList<Weapon> weapons = ProgramWindow.getWeaponList();
        int yPos = 480;
        ButtonGroup weaponSelection = new ButtonGroup();
        for (int i = 0; i < weapons.size(); i++) {
            Weapon currentWeapon = weapons.get(i);
            JRadioButton currentWeaponRadio = new JRadioButton(currentWeapon.getWeaponName());
            currentWeaponRadio.setBounds(30, yPos, 150, 50);
            int finalI = i;
            currentWeaponRadio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //set all characteristics about selected weapon
                    ProgramWindow.setSelectedWeapon(finalI);
                    String imagePath = currentWeapon.getWeaponName() + ".jpg";
                    ImageIcon weaponImage = new ImageIcon(getClass().getResource(imagePath));
                    weaponImageLabel.setIcon(weaponImage);
                    weaponInfo.setText(currentWeapon.getDescription());
                    attackModifierField.setText(String.valueOf(currentWeapon.getAttackMod()));
                    weightField.setText(String.valueOf(currentWeapon.getWeight()));
                }
            });
            weaponSelection.add(currentWeaponRadio);
            this.add(currentWeaponRadio);
            yPos += 40;
        }


        //ReRoll button
        reRollButton = new JButton("ReRoll");
        reRollButton.setBounds(520, 340, 200, 50);
        this.add(reRollButton);

        JLabel weaponStatsLabel = new JLabel("Weapon Stats:");
        weaponStatsLabel.setBounds(530, 440, 100, 20);
        this.add(weaponStatsLabel);

        //start battle button
        startBattleButton = new JButton("Start Battle");
        startBattleButton.setBounds(520, 620, 200, 50);
        this.add(startBattleButton);
    }


    public JButton getStartBattleButton() {
        return startBattleButton;
    }

    public JButton getReRollButton() {
        return reRollButton;
    }

    public JTextField getCharacterName() {
        return characterName;
    }

    //method to put together final character for next screen.
    public void createFinalPlayer(){
        String name = characterName.getText();
        Player selectedPlayer = ProgramWindow.getPlayerList().get(ProgramWindow.getSelectedPlayer());
        Weapon selectedWeapon = ProgramWindow.getWeaponList().get(ProgramWindow.getSelectedWeapon());
        selectedPlayer.setName(name);
        selectedPlayer.setWeapon(selectedWeapon);
    }
    //method used to reRoll stats for player
    public void reIssueIntValues(){
        Player selectedPlayer = ProgramWindow.getPlayerList().get(ProgramWindow.getSelectedPlayer());
        selectedPlayer.setHp(Character.generateRandomInt());
        selectedPlayer.setDefence(Character.generateRandomInt());
        selectedPlayer.setAgility(Character.generateRandomInt());
        selectedPlayer.setBaseAttack(Character.generateRandomInt());
        hpField.setText(String.valueOf(selectedPlayer.getHp()));
        defenseField.setText(String.valueOf(selectedPlayer.getDefence()));
        agilityField.setText(String.valueOf(selectedPlayer.getAgility()));
        baseAttackField.setText(String.valueOf(selectedPlayer.getBaseAttack()));
    }

    //method used to reset the values to blank boxes when game is restarted
    public void resetValues(){
        hpField.setText("");
        defenseField.setText("");
        agilityField.setText("");
        baseAttackField.setText("");
        ImageIcon playerImage = new ImageIcon(getClass().getResource("placeholder.jpg"));
        charImageLabel.setIcon(playerImage);
        characterInfo.setText("");
        characterName.setText("");
        weightField.setText("");
        attackModifierField.setText("");
        ImageIcon weaponImage = new ImageIcon(getClass().getResource("placeholder.jpg"));
        weaponImageLabel.setIcon(weaponImage);
        weaponInfo.setText("");
    }


    public JTextField getHpField() {
        return hpField;
    }

    public JTextField getDefenseField() {
        return defenseField;
    }

    public JTextField getAgilityField() {
        return agilityField;
    }

    public JTextField getBaseAttackField() {
        return baseAttackField;
    }

    public void setCharacterName(JTextField characterName) {
        this.characterName = characterName;
    }

    public void setHpField(JTextField hpField) {
        this.hpField = hpField;
    }

    public void setDefenseField(JTextField defenseField) {
        this.defenseField = defenseField;
    }

    public void setAgilityField(JTextField agilityField) {
        this.agilityField = agilityField;
    }

    public void setBaseAttackField(JTextField baseAttackField) {
        this.baseAttackField = baseAttackField;
    }
}
