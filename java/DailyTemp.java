/*
https://leetcode.com/problems/daily-temperatures/

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/


public class TempObj{
        int temp;
        int index;
        public TempObj(int t, int i){
            this.temp = t;
            this.index = i;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        TreeSet<TempObj> s = new TreeSet<>(new Comparator<TempObj>(){
            @Override
            public int compare(TempObj o1, TempObj o2){
                return o1.temp == o2.temp ? 
                    o2.index - o1.index : o1.temp - o2.temp;
            }
        });
        
        int[] res = new int[T.length];
        
        for(int i=0; i<T.length; i++){
            TempObj n = new TempObj(T[i], i);
            while(true){
                TempObj f = s.floor(n);
                if(f != null){
                    res[f.index] = n.index - f.index;
                    s.remove(f);
                } else {
                    break;
                }
            }
            s.add(n);
        }
        
        Iterator<TempObj> it = s.iterator();
        while(it.hasNext()){
            TempObj f = it.next();
            res[f.index] = 0;
        }

        return res;
    } 
