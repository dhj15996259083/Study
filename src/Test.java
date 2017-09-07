import java.util.Arrays;

/**
 * Created by daihuijun on 2017/5/2.
 */
public class Test {
    static int[] array1 = new int[]{2,6,2,3,1,5,7,0,52,32,7};
    static int[] array2 = new int[]{2,16,2,13,11,5,17,0,52,32,7};
    public static void main(String[] args) {
        Test test = new Test();
//        Integer i = 123456789;
//
//        System.out.println(test.covert(i));
//
//        test.haino(3,"a","b","c");

        test.sort(array1, 0, array1.length - 1);
        test.sort(array2, 0, array2.length - 1);

        int[] array = test.combin(array1,array2);
        for(int j = 0;j<array.length;j++){

            System.out.println(array[j]);
        }
//        test.visitTree(TreeNode.root);
    }




    public String covert(int a) {
        return covert(a+"");
    }

    private String covert(String a) {
        if(a.length() == 1) {
            return a;
        }else{
            return covert(a.substring(1))+a.substring(0,1);
        }
    }



    public void haino(int i, String a, String b, String c){
        if(i == 1) {
            System.out.println("从"+a+"到"+b);
        }else{
            haino(i-1,a,c,b);
            System.out.println("从"+a+"到"+b);
            haino(i-1,c,b,a);
        }
    }


    public void sort(int[] array, int left, int rigth) {
        int i = left,j= rigth;
        if(i >= j)
            return;
        int standard = array[left];


        while(i != j) {
            while(j > i && array[j] >= standard){
                j--;
            }
            while(j > i&& array[i] <= standard) {
                i++;
            }
            if(i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left]=array[i];
        array[i]=standard;
        sort(array, left, i-1);
        sort(array, i + 1, rigth);
    }

    public void visitTree(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.value);
        visitTree(node.left);
        visitTree(node.right);
    }


    public int[] combin(int[] array1, int[] array2){
        int current = 0;
        int[] c = new int[Math.max(array1.length,array2.length)];
        int i = 0, j=0;
        while(i<array1.length&&j<array2.length){
            if(array1[i] < array2[j]){
                i++;
            }
            if(array1[i] > array2[j]){
                j++;
            }
            if(array1[i] == array2[j]){
                c[current] = array1[i];
                current++;
                j++;i++;
            }
        }
        return Arrays.copyOf(c, current);

    }
}

class TreeNode {
    static TreeNode root;
    int value;
    TreeNode left;
    TreeNode right;

    static {
        TreeNode root = new TreeNode();
        root.value = 1;
        TreeNode left1=new TreeNode();
        left1.value = 2;
        TreeNode right1 = new TreeNode();
        right1.value = 3;
        root.left = left1;
        root.right = right1;
        TreeNode right1_left2 = new TreeNode();
        right1_left2.value = 5;
        TreeNode right1_right2 = new TreeNode();
        right1_right2.value = 7;
        right1.right = right1_right2;
        right1.left = right1_left2;
        TreeNode.root = root;
    }
}