import entity.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @author  chenhanyi
 */

public class MaxPoint {


    /**
     * 需要两重循环，第一重循环遍历起始点a，第二重循环遍历剩余点b。
     * a和b如果不重合，就可以确定一条直线。
     * 对于每个点a，构建 斜率->点数 的map。
     * (1)b与a重合，以a起始的所有直线点数+1 (用dup统一相加)
     * (2)b与a不重合，a与b确定的直线点数+1
     */
    public int maxPoint(Point[] points) {

        int len = points.length;

        int ret = 0;
        for (int i = 0; i < len; i++) {
            //记录与i点垂直和重合的点
            int dup = 0,vtl = 0;
            //当前最大连接点数
            int curMax = 1;
            //对于每个点a，构建 斜率->点数 的map
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = 0; j < len; j++) {
                if(j == i) continue;
                double x1 = points[i].x - points[j].x;
                double y1 = points[i].y - points[j].y;
                if (x1 == 0 && y1 == 0) {//点重复
                    dup++;
                }else if(x1 == 0){
                    if(vtl == 0){
                        vtl = 2;
                    }else{
                        vtl ++;
                    }
                    curMax = Math.max(curMax,vtl);
                }
                else {
                    Double k = (x1 / y1);
                    if (map.get(k) == null) {
                        map.put(k, 2);
                    } else {
                        int num = map.get(k);
                        map.put(k, ++num);
                    }
                    curMax = Math.max(curMax,map.get(k));
                }
            }
            ret = Math.max(ret,curMax+dup);
        }
        return ret;
    }
}