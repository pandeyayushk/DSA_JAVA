package Recursion.backtracking;
import java.util.*;
public class maze {
    public static void main(String[] args) {
        int count=numberOfWays( 2, 2, 0, 0);
        System.out.println(count);
        System.out.println(printWay(2, 2, 0, 0, ""));
        System.out.println(printWayDiagonally(2, 2, 0, 0, ""));
        System.out.println(numberOfWaysObstacle(2, 2, 0, 0, 1, 1));
        System.out.println(printWayObstacles(2, 2, 0, 0,"", 1, 1));
        boolean[][] obstacles={{true,true,true},{true,true,true},{true,true,true}};
        System.out.println(printWayObstaclesArray(2, 2, 0, 0,"", obstacles));
        System.out.println(allDirections(2, 2, 0, 0,"", obstacles));
        int [][] path={{0,0,0},{0,0,0},{0,0,0}};
        List<String> ans=allDirectionsMatrixPath(2, 2, 0, 0,"", obstacles, path,1);
        System.out.println(ans);
    }
    static int numberOfWays(int targetRow,int targetCol,int sRow,int sCol){
        if(sRow==targetRow&&sCol==targetCol){
            return 1;
        }
        int count=0;
        if(sRow<targetRow){
            count+=numberOfWays(targetRow, targetCol, sRow+1, sCol);
        }
        if(sCol<targetCol){
            count+=numberOfWays(targetRow, targetCol, sRow, sCol+1);
        }
        return count;
    }
    static List<String> printWay(int targetRow,int targetCol,int sRow,int sCol,String processed){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> soln=new ArrayList<>();
        if(sRow<targetRow){
            soln.addAll(printWay(targetRow, targetCol, sRow+1, sCol,processed+'D'));
        }
        if(sCol<targetCol){
            soln.addAll(printWay(targetRow, targetCol, sRow, sCol+1,processed+'R'));
        }
        return soln;
    }
    static List<String> printWayDiagonally(int targetRow,int targetCol,int sRow,int sCol,String processed){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> soln=new ArrayList<>();
        if(sRow<targetRow){
            soln.addAll(printWayDiagonally(targetRow, targetCol, sRow+1, sCol,processed+'D'));
        }
        if(sCol<targetCol){
            soln.addAll(printWayDiagonally(targetRow, targetCol, sRow, sCol+1,processed+'R'));
        }
        if(sRow<targetRow&&sCol<targetCol){
            soln.addAll(printWayDiagonally(targetRow, targetCol, sRow+1, sCol+1,processed+'d'));
        }
        return soln;
    }

    static int numberOfWaysObstacle(int targetRow,int targetCol,int sRow,int sCol,int obsRow,int obsCol){
        if(sRow==targetRow&&sCol==targetCol){
            return 1;
        }
        if(sRow==obsRow&&sCol==obsCol){
            return 0;
        }
        int count=0;
        if(sRow<targetRow){
            count+=numberOfWaysObstacle(targetRow, targetCol, sRow+1, sCol,obsRow,obsCol);
        }
        if(sCol<targetCol){
            count+=numberOfWaysObstacle(targetRow, targetCol, sRow, sCol+1,obsRow,obsCol);
        }
        return count;
    }

    static List<String> printWayObstacles(int targetRow,int targetCol,int sRow,int sCol,String processed,int obsRow,int obsCol){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        if(sRow==obsRow&&sCol==obsCol){
            return new ArrayList<String>();
        }
        List<String> soln=new ArrayList<>();
        if(sRow<targetRow){
            soln.addAll(printWayObstacles(targetRow, targetCol, sRow+1, sCol,processed+'D',obsRow,obsCol));
        }
        if(sCol<targetCol){
            soln.addAll(printWayObstacles(targetRow, targetCol, sRow, sCol+1,processed+'R',obsRow,obsCol));
        }
        return soln;
    }

    static List<String> printWayObstaclesArray(int targetRow,int targetCol,int sRow,int sCol,String processed,boolean[][] obs){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        if(!obs[sRow][sCol]){
            return new ArrayList<String>();
        }
        List<String> soln=new ArrayList<>();
        if(sRow<targetRow){
            soln.addAll(printWayObstaclesArray(targetRow, targetCol, sRow+1, sCol,processed+'D',obs));
        }
        if(sCol<targetCol){
            soln.addAll(printWayObstaclesArray(targetRow, targetCol, sRow, sCol+1,processed+'R',obs));
        }
        return soln;
    }
    // If we try to move in all direction with this approach we will always go back to our start point
    // in a recursion call and stack will overflow
    // to solve this we can mark the cells we have visited and not allow the recursion calls to go back there
    // just  like we stopped out recursion call to go to the obstacle in the obstacles maze
    // in this we will stop out recursion calls to go to cells already visited by marking those cells as false.
    // Dont forget to unmark the cells after the recursion call so the other calls can use it
    // we wwant it marked for the recursion call which has already visited there not all other recursion calls

    static List<String> allDirections(int targetRow,int targetCol,int sRow,int sCol,String processed,boolean[][] obs){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            return list;
        }
        if(!obs[sRow][sCol]){
            return new ArrayList<String>();
        }
        List<String> soln=new ArrayList<>();
        obs[sRow][sCol]=false;
        if(sRow<targetRow){
            soln.addAll(allDirections(targetRow, targetCol, sRow+1, sCol,processed+'D',obs));
        }
        if(sCol<targetCol){
            soln.addAll(allDirections(targetRow, targetCol, sRow, sCol+1,processed+'R',obs));
        }
        if(sRow>0){
            soln.addAll(allDirections(targetRow, targetCol, sRow-1, sCol, processed+'U', obs));
        }
        if(sCol>0){
            soln.addAll(allDirections(targetRow, targetCol, sRow, sCol-1, processed+'L', obs));   
        }
        obs[sRow][sCol]=true;
        return soln;
    }

    static List<String> allDirectionsMatrixPath(int targetRow,int targetCol,int sRow,int sCol,String processed,boolean[][] obs,int[][] matrixPath,int steps){
        if(sRow==targetRow&&sCol==targetCol){
            List<String> list=new ArrayList<>();
            list.add(processed);
            matrixPath[sRow][sCol]=steps;
            for(int[] arr:matrixPath){
                for(int e:arr){
                    System.out.print(e+" ");
                }
                System.out.println();
            }
            System.out.println();
            matrixPath[sRow][sCol]=0;
            return list;
        }
        if(!obs[sRow][sCol]){
            return new ArrayList<String>();
        }
        List<String> soln=new ArrayList<>();
        obs[sRow][sCol]=false;
        matrixPath[sRow][sCol]=steps;
        if(sRow<targetRow){
            soln.addAll(allDirectionsMatrixPath(targetRow, targetCol, sRow+1, sCol,processed+'D',obs,matrixPath,steps+1));
        }
        if(sCol<targetCol){
            soln.addAll(allDirectionsMatrixPath(targetRow, targetCol, sRow, sCol+1,processed+'R',obs,matrixPath,steps+1));
        }
        if(sRow>0){
            soln.addAll(allDirectionsMatrixPath(targetRow, targetCol, sRow-1, sCol, processed+'U', obs,matrixPath,steps+1));
        }
        if(sCol>0){
            soln.addAll(allDirectionsMatrixPath(targetRow, targetCol, sRow, sCol-1, processed+'L', obs,matrixPath,steps+1));   
        }
        obs[sRow][sCol]=true;
        matrixPath[sRow][sCol]=0;
        return soln;
    }
}
