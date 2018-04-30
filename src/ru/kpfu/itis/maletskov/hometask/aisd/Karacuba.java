package ru.kpfu.itis.maletskov.hometask.aisd;

public class Karacuba {

   private boolean[] xl;
   private boolean[] xr;
   private boolean[] yl;
   private boolean[] yr;
   private int base;

   public static void main(String[] args) {
      Karacuba ak = new Karacuba(2145, 7654);
   }

   public Karacuba(int x, int y) {
      String x1 = Integer.toBinaryString(x);
      String y1 = Integer.toBinaryString(y);
      int maxLen = Math.max(x1.length(), y1.length());
      maxLen = maxLen % 2 == 1 ? maxLen + 1 : maxLen;
      this.xl = new boolean[maxLen / 2];
      this.yl = new boolean[maxLen / 2];
      this.xr = new boolean[maxLen / 2];
      this.yr = new boolean[maxLen / 2];
      for (int i = maxLen - 1; i >= 0; i--) {
         if (i < maxLen / 2) {
            this.xl[i] = x % 2 == 1;
         } else {
            this.xr[i - maxLen / 2] = x % 2 == 1;
         }
         x /= 2;
      }
      for (int i = maxLen - 1; i >= 0; i--) {
         if (i < maxLen / 2 ) {
            this.yl[i] = y % 2 == 1;
         } else {
            this.yr[i - maxLen / 2] = y % 2 == 1;
         }
         y /= 2;
      }
      base = this.xl.length;
      this.multiByKaracuba();
   }

   public boolean[] multiply(boolean[] x1, boolean[] y1){
      boolean[] x11 = x1;
      boolean[] y11 = y1;
      if (x1.length != y1.length) {
         if (x1.length < y1.length) {
            System.arraycopy(x11,0, x1 = new boolean[y1.length], y11.length - x11.length, x11.length);
         } else{
            System.arraycopy(y11,0, y1 = new boolean[x1.length], x11.length - y11.length, y11.length);
         }
      }
      boolean[] sum = new boolean[y1.length + 1];
      for (int i = x1.length - 1; i >= 0; i--) {
         if (i == x1.length - 1) {
            if (x1[i]) {
               System.arraycopy(y1, 0, sum, 1, y1.length);
            }
            i--;
         }
         boolean[] m11 = new boolean[2 * y1.length - i - 1];
         if (x1[i]) {
            System.arraycopy(y1, 0, m11, 0, y1.length);
         }
         if (sum.length == this.summation(m11, sum).length) {
            boolean[] sum1 = this.summation(m11, sum);
            sum = new boolean[sum.length + 1];
            System.arraycopy(sum1, 0, sum, 1, sum1.length);
         } else {
            sum = this.summation(m11, sum);
         }
      }
      return sum;
   }

   public boolean[] summation(boolean[] x1, boolean[] y1) {
      boolean[] x11 = x1;
      boolean[] y11 = y1;
      if (x1.length != y1.length) {
         if (x1.length < y1.length) {
            System.arraycopy(x11, 0, x1 = new boolean[y1.length], y11.length - x11.length, x11.length);
         } else{
            System.arraycopy(y11, 0, y1 = new boolean[x1.length], x11.length - y11.length, y11.length);
         }
      }
      boolean[] x1y1 = new boolean[x1.length];
      boolean a = false;
      for (int i = x1.length - 1; i >= 0; i--) {
         if (x1[i]) {
            if (y1[i]) {
               if (a) {
                  x1y1[i] = true;
                  a = true;
               } else {
                  x1y1[i] = false;
                  a = true;
               }
            } else {
               x1y1[i] = !(a);
            }
         } else {
            if (y1[i] & a) {
               x1y1[i] = false;
            } else {
               if (y1[i] | a) {
                  x1y1[i] = true;
                  a = false;
               }
            }
         }
      }
      if (a) {
         boolean[] xy = new boolean[x1y1.length + 1];
         System.arraycopy(x1y1, 0, xy, 1, x1y1.length);
         xy[0] = true;
         return xy;
      }
      return x1y1;
   }

   public boolean[] cut(boolean[] array) {
      int size = array.length;
      for (int i = 0; i < array.length; i++) {
         if (array[i]) {
            break;
         }
         size--;
      }
      boolean[] xy = new boolean[size];
      System.arraycopy(array, array.length - size, xy, 0, xy.length);
      return xy;
   }

   public void multiByKaracuba() {
      boolean[] x1y1 = this.multiply(this.xl, this.yl);
      x1y1 = this.cut(x1y1);
      boolean[] x1y2 = this.multiply(this.xl, this.yr);
      x1y2 = this.cut(x1y2);
      boolean[] x2y1 = this.multiply(this.xr,this.yl);
      x2y1 = this.cut(x2y1);
      boolean[] x2y2 = this.multiply(this.xr, this.yr);
      x2y2 = this.cut(x2y2);
      boolean[] baseAr = new boolean[(int)base * 2 + 1];
      baseAr[0] = true;
      x1y1 = this.multiply(x1y1, baseAr);
      x1y1 = this.cut(x1y1);
      baseAr = new boolean[(int)base + 1];
      baseAr[0] = true;
      x1y2 = this.summation(x1y2, x2y1);
      x1y2 = this.cut(this.multiply(this.cut(x1y2), baseAr)) ;
      x1y1 = this.cut(this.summation(x1y1, x1y2));
      x1y1 = this.cut(this.summation(x1y1, x2y2));
      int sum = 0;
      for (int i = 0; i < x1y1.length; i++) {
         if (x1y1[i]) {
            sum +=(int) Math.pow(2, x1y1.length - i - 1);
         }
      }
      System.out.println(sum);
   }
}
