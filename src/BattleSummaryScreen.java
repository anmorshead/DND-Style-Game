import javax.swing.*;
import java.awt.*;

public class BattleSummaryScreen extends JPanel {

    private JButton playAgainButton;
    private JTextArea battleInfo;
    private JLabel monsterImage;
    private JLabel playerLabel;
    private JLabel monsterLabel;
    private JLabel selectedPlayerImage;
    public BattleSummaryScreen(){
        this.setBounds(0,0,800,800);
        this.setBackground(new Color(194, 235, 91));
        this.setLayout(null);
        this.setVisible(true);

        JLabel finalMessage = new JLabel("Battle To The Death!");
        finalMessage.setBounds(260,30,300,100);
        finalMessage.setFont(new Font ("Engravers Old English",Font.BOLD,35));
        this.add(finalMessage);

        playerLabel = new JLabel("Player: ");
        playerLabel.setBounds(120, 150, 125, 20);
        this.add(playerLabel);

        selectedPlayerImage = new JLabel("image goes here");
        selectedPlayerImage.setBounds(120, 190, 125, 125);
        selectedPlayerImage.setIcon(new ImageIcon(getClass().getResource("placeholder.jpg"))); // set image to the icon
        this.add(selectedPlayerImage);

        monsterLabel = new JLabel("Monster: ");
        monsterLabel.setBounds(540, 150, 175, 20);
        this.add(monsterLabel);

        monsterImage = new JLabel("image goes here");
        monsterImage.setBounds(540, 190, 125, 125);
        monsterImage.setIcon(new ImageIcon(getClass().getResource("placeholder.jpg"))); // set image to the icon
        this.add(monsterImage);

        //display info about battle
        battleInfo = new JTextArea();
        battleInfo.setBounds(70,340,660,300);
        battleInfo.setLineWrap(true); // Enable word wrap
        battleInfo.setWrapStyleWord(true); // Wrap at word boundaries
        this.add(battleInfo);

        //play again button
        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(310,680,200,50);
        this.add(playAgainButton);

    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }

    //method to print all needed info into the textArea
    public String printBattleInfo() {
        Player selectedPlayer = ProgramWindow.getPlayerList().get(ProgramWindow.getSelectedPlayer());
        Weapon selectedWeapon = ProgramWindow.getWeaponList().get(ProgramWindow.getSelectedWeapon());
        Monster theMonster = ProgramWindow.getMonster();

        return "Player: " + selectedPlayer.getName() +
                "\n--------------------------" +
                "\nClass: " + selectedPlayer.getClass().getSimpleName() +
                "\nHP: " + selectedPlayer.getHp() + "  Defence: " + selectedPlayer.getDefence() + "  Agility: " + selectedPlayer.getAgility() + "  Base Attack: " + selectedPlayer.getBaseAttack()+
                "\nWeapon: " + selectedWeapon.getWeaponName() + "       Weight: " + selectedWeapon.getWeight() + "  Attack Mod: " + selectedWeapon.getAttackMod() +
                "\n" +
                "\nMonster: " + theMonster.getName() +
                "\n--------------------------" +
                "\nHP: " + theMonster.getHp() + "   Defence: " + theMonster.getDefence() + "    Agility: " + theMonster.getAgility() + "    Base Attack: " + theMonster.getBaseAttack() +
                "\n "+
                "\n" + theMonster.getMonsterDescription();

    }

    //used to set all info on this page from the selected character and weapon from previous screen
    public void displayPlayerInfo() {
        Player selectedPlayer = ProgramWindow.getPlayerList().get(ProgramWindow.getSelectedPlayer());
        battleInfo.setText(printBattleInfo());
        String playerImagePath = selectedPlayer.getClass().getSimpleName() + ".jpg";
        ImageIcon playerImage = new ImageIcon(getClass().getResource(playerImagePath));
        selectedPlayerImage.setIcon(playerImage);
        playerLabel.setText(playerLabel.getText()+ selectedPlayer.getClass().getSimpleName());
        monsterLabel.setText(monsterLabel.getText()+ ProgramWindow.getMonster().getName());
        String monsterImagePath = ProgramWindow.getMonster().getName() + ".jpg";
        ImageIcon monsterImageIcon = new ImageIcon(getClass().getResource(monsterImagePath));
        monsterImage.setIcon(monsterImageIcon);

    }
    //used to reset info when game is restarted
    public void resetInfoArea(){
        battleInfo.setText("");
        playerLabel.setText("Player: ");
        monsterLabel.setText("Monster: ");
        //reset monster instance
        ProgramWindow.setMonster(new Monster(Monster.generateRandomName(),Character.generateRandomInt(),Character.generateRandomInt(),Character.generateRandomInt(),Character.generateRandomInt(),null));
    }

}
