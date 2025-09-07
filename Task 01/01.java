import java.util.Arrays;

public class CourseScheduler {
  
        public static int maxNonOverlappingCourses(int[][]courses)
        {
            Arrays.sort(courses, (a, b) -> a[1] -b[1]);
            int count=0;
            int lastEnd=-1;
            for(int i=0;i<courses.length ;++i)
            {
                if(courses[i][0]>=lastEnd)
                {
                    count++;
                    lastEnd=courses[i][1];

                }
            }
            return count;
        }

        public static void main(String[]args)
        {
        System.out.println(maxNonOverlappingCourses(new int[][]{{9, 11}, {10, 12}, {11, 13}, {15, 16}})); // 3
        System.out.println(maxNonOverlappingCourses(new int[][]{{19, 22}, {17, 19}, {9, 12}, {9, 11}, {15, 17}, {15, 17}})); // 4
        System.out.println(maxNonOverlappingCourses(new int[][]{{19, 22}})); // 1
        System.out.println(maxNonOverlappingCourses(new int[][]{{13, 15}, {13, 17}, {11, 17}})); // 1
        }
}
