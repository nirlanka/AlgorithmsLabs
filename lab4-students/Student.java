class Student extends BTree<Grade> implements Comparable<Student> {

         double gpa;
         int courses;
         String name, regnum;

         Student (String name, String regnum) {
            this.name=name;
            this.regnum=regnum;
         }

         @Override
         public void in_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                
                in_order(grade.left);
                
                gpa+=grade.data.grade;
                courses++;

                in_order(grade.right);
                
            }
         }

         @Override
         public void in_order() {
            in_order(rootNode);
         }

         public void rev_in_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                
                rev_in_order(grade.right);
 
                System.out.print(grade.data.grade+" ");
                
                rev_in_order(grade.left);
                
            }
         }

         public void rev_in_order() {
            rev_in_order(rootNode);
         }

         double getGPA() {
            gpa=0.0;
            courses=0;
            in_order();
            gpa/=courses;
            gpa=((double) Math.round(100*gpa))/100;
            return gpa;
         }

         double getCachedGPA() {
            return gpa;
         }

         @Override
         public int compareTo(Student to) {
            return (int) -(10*(getGPA()-to.getGPA()));
         }
    };