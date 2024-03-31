import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class tictactoe extends JPanel
{
    static JFrame frame;
    static List<JButton> fieldButtons;
    static JLabel informLabel;

    static String[] gameField;
    static String turn;
    static boolean winner;
    static int cellValue;

    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictactoe crosses = new tictactoe();
        frame.add(crosses);
        frame.setContentPane(crosses);
        frame.setVisible(true);

        fieldButtons = new ArrayList<JButton>();
        informLabel = new JLabel("Добро пожаловать ");

        gameField = new String[9];
        turn = "X";
        winner = false;
        cellValue = 0;
        Game();
    }

    private static void Game()
    {
        frame.setLayout(null);
        informLabel.setBounds(10, 160, 400, 400);
        frame.add(informLabel);
        int xInc = 0;
        int yInc = -100;

        for(int i = 0; i < 9; i++) gameField[i] = "empty";
        {
            for (int y = 0; y < 3; y++)
            {
                xInc = 0;
                yInc += 100;
                for (int x = 0; x < 3; x++)
                {
                    fieldButtons.add(new JButton(""));
                    fieldButtons.get(cellValue).setBounds(xInc, yInc, 100, 100);
                    frame.add(fieldButtons.get(cellValue));
                    fieldButtons.get(cellValue).addActionListener(new ActionListener()
                    {
                        final int value = cellValue;

                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            if (!winner && Objects.equals(gameField[value], "empty"))
                            {
                                gameField[value] = turn;
                                fieldButtons.get(value).setText(turn);

                                if(CheckWin())informLabel.setText("Победил " + turn);

                                if (Objects.equals(turn, "X")) turn = "O";
                                else turn = "X";
                            }
                            else informLabel.setText("клетка занята");
                        }
                    });
                    cellValue++;
                    xInc += 100;
                }
                frame.setSize(300, 450);
                frame.setResizable(false);
            }
        }
    }

    private static boolean CheckWin()
    {
        if((Objects.equals(gameField[0], gameField[1])) && (Objects.equals(gameField[0], gameField[2])) && (!Objects.equals(gameField[0], "empty")))
        {
           return true;
        }
        else if (Objects.equals(gameField[3], gameField[4]) && Objects.equals(gameField[3], gameField[5]) && !Objects.equals(gameField[3], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[6], gameField[7]) && Objects.equals(gameField[6], gameField[8]) && !Objects.equals(gameField[6], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[0], gameField[3]) && Objects.equals(gameField[0], gameField[6]) && !Objects.equals(gameField[0], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[1], gameField[4]) && Objects.equals(gameField[1], gameField[7]) && !Objects.equals(gameField[1], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[2], gameField[5]) && Objects.equals(gameField[2], gameField[8]) && !Objects.equals(gameField[2], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[0], gameField[4]) && Objects.equals(gameField[0], gameField[8]) && !Objects.equals(gameField[0], "empty"))
        {
            return true;
        }
        else if (Objects.equals(gameField[2], gameField[4]) && Objects.equals(gameField[2], gameField[8]) && !Objects.equals(gameField[2], "empty"))
        {
            return true;
        }
        return false;
    }
}
