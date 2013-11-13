import java.util.*;

public class Practice {

  private static final int NUMBER_OF_ASCII = 256;
  
  public static void main(String[] args) {
    
    int[][] matrix = { {1, 2, 3},
                       {4, 5, 6},
                       {7, 0, 8} };

    replaceZeros(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }    

    /*
    Scanner in = new Scanner(System.in);
    String input = in.next(); 

    String compressed = compress(input);
    System.out.println(compressed);
    
    char[] array = input1.toCharArray();
    replace(array, 13);

    System.out.println();
    
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
    System.out.println();

    boolean isPermutation = isPerm(input1, input2);
    System.out.println(isPermutation);
    
    String reversed1 = reverse1(input);
    System.out.println(reversed1);

    String reversed2 = reverse2(reversed1);
    System.out.println(reversed2);

    boolean isUniqueVal1 = isUnique1(input);
    System.out.println(isUniqueVal1);
    
    boolean isUniqueVal2 = isUnique2(input);
    System.out.println(isUniqueVal2);
    */
  }

  private static void replaceZeros(int[][] matrix) {
    
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    } 

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  private static String compress(String str) {
    
    int length = str.length();
    if (length <= 2) {
      return str;
    }
   
    StringBuffer sb = new StringBuffer();
    char current = str.charAt(0);
    int count = 1;

    for (int i = 1; i < length; i ++) {
      
      char next = str.charAt(i);
      if (current == next) {
        count++;
      } else {
        sb.append(current);
        sb.append(count);
        current = next;
        count = 1;
      }
      
      if (i == length - 1) {
        sb.append(current);
        sb.append(count);
      }
    }
    if (sb.length() < length) {
      return sb.toString();
    } else {
      return str;
    }
  }

  //1.4
  private static void replace(char[] s, int length) {
    
    int frontPointer = length - 1;
    int backPointer = s.length - 1;

    while (frontPointer != backPointer) {
      
      if (s[frontPointer] != ' ') {
        
        char tmp = s[frontPointer];
        s[frontPointer] = s[backPointer];
        s[backPointer] = tmp;
        frontPointer--;
        backPointer--;

      } else {
        s[backPointer] = '0';
        backPointer--;
        s[backPointer] = '2';
        backPointer--;
        s[backPointer] = '%';
        backPointer--;
        frontPointer--;

      }
    }
  }

  // 1.3
  private static boolean isPerm(String str1, String str2) {
    
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] count = new int[NUMBER_OF_ASCII];
    
    for (int i = 0; i < str1.length(); i++) {
      count[str1.charAt(i)]++;
    }

    for (int i = 0; i < str2.length(); i++) {
      count[str2.charAt(i)]--;
      if (count[str2.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }

  // 1.2
  private static String reverse2(String str) {
    
    char[] charArray = str.toCharArray();
       
 
    for (int i = 0; i < ((charArray.length / 2) - 1); i++) {
      char tmp = charArray[i];
      charArray[i] = charArray[charArray.length - 1 - i];
      charArray[charArray.length - 1 - i] = tmp;
    }
    return new String(charArray);
  }

  private static String reverse1(String str) {
    StringBuffer sb = new StringBuffer(str);
    return sb.reverse().toString();
  }



  // 1,1
  private static boolean isUnique2(String str) {
    
    boolean[] char_set = new boolean[NUMBER_OF_ASCII];

    for (int i = 0; i < str.length(); i++) {
      if (!char_set[str.charAt(i)]) {
        char_set[str.charAt(i)] = true;
      } else {
        return false;
      }
    }
    return true;
  }

  private static boolean isUnique1(String str) {
    
    Set<Character> char_set = new HashSet<Character>();
    
    for (int i = 0; i < str.length(); i++) {
      char_set.add(str.charAt(i));
    }

    for (int i = 0; i <str.length(); i++) {
      if (char_set.contains(str.charAt(i))) {
        char_set.remove(str.charAt(i));
      } else {
        return false;
      }
    }
    return true;
  }

}
