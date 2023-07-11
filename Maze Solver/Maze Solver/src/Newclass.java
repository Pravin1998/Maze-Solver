import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Newclass extends JFrame {
    private  int [][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,1,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,1,0,1,0,1,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,0,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,1,0,1,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},

    };
    public ArrayList<Integer> path = new ArrayList<>();
       Dimension size;
       public Newclass(){
            setLayout(null);

            setTitle("Maze Solver");
        //  setSize(640,720);
            getContentPane().setBackground(Color.RED);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Depthfirst.searchpath(maze,1,1,path);
            System.out.println( path);
            size = new Dimension(Toolkit. getDefaultToolkit(). getScreenSize());
            getContentPane().setBackground(Color.RED);

    }
    @Override
    public void paint(Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image ii = t.getImage("C:\\Users\\master-55\\Desktop\\Maze Solver\\Maze Solver\\images\\Wall.jpg");
        g.drawImage(ii,00,00,this);
           g.translate(200,180);
        for(int i=0; i<maze.length;i++){
            for(int j=0;j<maze[0].length; j++){
                Color color;
                switch (maze[i][j]){
                    case 1 : color = Color.BLACK;
                    break;
                    case 9 : color = Color.RED;
                    break;
                    default: color = Color.WHITE;

                }
                g.setColor(color);
                g.fillRect(40*j,40*i,40,40);
                g.setColor(Color.RED);
                g.drawRect(40*j,40*i,40,40);
            }
        }
        for(int i=0; i<path.size(); i=i+2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            System.out.println("X coordinates"+pathx);
            System.out.println("Y coordinates" +pathy);
            g.setColor(Color.GREEN);
            g.fillRect(40*pathx,40*pathy,35,35);
        }
    }

    public static void main(String[] args) {
        Newclass view  = new Newclass();
        view.setVisible(true);
    }

}
