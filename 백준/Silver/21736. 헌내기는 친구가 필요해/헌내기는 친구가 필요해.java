import java.util.*;
import java.io.*;
public class Main {
    static char[][] map;
    public static class position{
        int x;
        int y;
        position(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int BFS(int x, int y){
        Queue<position> queue=new LinkedList<>();
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        position stdHouse=new position(x,y);
        queue.offer(stdHouse);
        int cnt=0;
        map[y][x]='X';
        while (!queue.isEmpty()){
            position poppedHouse= queue.poll();
            for(int i=0;i<4;i++){
                int newX= poppedHouse.x+dx[i];
                int newY= poppedHouse.y+dy[i];
                if(newX<0||newY<0||newX>= map[0].length||newY>= map.length)
                    continue;
                if(map[newY][newX]=='O'){
                    position newPosition= new position(newX,newY);
                    map[newY][newX]='X';
                    queue.offer(newPosition);
                }else if(map[newY][newX]=='P'){
                    position newPosition= new position(newX,newY);
                    map[newY][newX]='X';
                    queue.offer(newPosition);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int height=Integer.parseInt(st.nextToken());
        int width=Integer.parseInt(st.nextToken());
        map = new char[height][width];
        position doyeon = null;

        for(int i=0;i<height;i++){
            String str= br.readLine();
            for(int j=0;j<width;j++){
                if(str.charAt(j)=='P')
                    map[i][j]='P';
                else if(str.charAt(j)=='I'){
                    doyeon=new position(j,i);
                    map[i][j]='O';
                }
                else if(str.charAt(j)=='X')
                    map[i][j]='X';
                else
                    map[i][j]='O';
            }
        }
        int answer=BFS(doyeon.x, doyeon.y);
        if(answer==0)
            System.out.println("TT");
        else
            System.out.println(answer);
    }
}