class Solution {
    int size = 0;
    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2]; //max heap
        for(int i = 0; i < points.length; i++) heapify(ret, points[i]); //heapify by adding to bottom until full and then adding to top
        return ret;
    }
    public void heapify(int[][] ret, int[] point){
        if(size<ret.length){
            ret[size] = point;
            bubbleUp(ret, size);
            size++;
        }
        else{
            double dist = Math.sqrt(Math.pow(ret[0][0], 2) + Math.pow(ret[0][1],2));
            double pDist = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1],2));
            if(pDist<dist){
                ret[0] = point;
                bubbleDown(ret, 0);
            }
        }

    }
    public void bubbleUp(int[][] ret, int index){
        while(true){
            int parent = (index-1)/2;
            int[] parCoord = ret[parent];
            int[] coords = ret[index];
            double parDist = Math.sqrt(Math.pow(parCoord[0], 2) + Math.pow(parCoord[1],2));
            double dist = Math.sqrt(Math.pow(coords[0], 2) + Math.pow(coords[1],2));
            if(dist>parDist){
                ret[index] = parCoord;
                ret[parent] = coords;
                if(index==0) break;
                index = parent;
            }
            else break;
        }
    }
    public void bubbleDown(int[][] ret, int index){
        while(true){
            int left = index*2 + 1;
            if(left>=ret.length) break;
            int right = index*2 + 2;
            if(right>=ret.length){
                int[] leftCoords = ret[left];
                int[] coords = ret[index];
                int biggest = index;
                double dist = Math.sqrt(Math.pow(coords[0], 2) + Math.pow(coords[1],2));
                double leftDist = Math.sqrt(Math.pow(leftCoords[0], 2) + Math.pow(leftCoords[1],2));
                if(leftDist>dist) biggest = left;
                if(biggest==index) break;
                int[] temp = ret[index];
                ret[index] = ret[biggest];
                ret[biggest] = temp;
                break;
            }
            int[] leftCoords = ret[left];
            int[] rightCoords = ret[right];
            int[] coords = ret[index];
            int biggest = index;
            double dist = Math.sqrt(Math.pow(coords[0], 2) + Math.pow(coords[1],2));
            double leftDist = Math.sqrt(Math.pow(leftCoords[0], 2) + Math.pow(leftCoords[1],2));
            double rightDist = Math.sqrt(Math.pow(rightCoords[0], 2) + Math.pow(rightCoords[1],2));
            if(leftDist>dist) biggest = left;
            if(rightDist > Math.max(dist, leftDist)) biggest = right;
            if(biggest==index) break;
            int[] temp = ret[index];
            ret[index] = ret[biggest];
            ret[biggest] = temp;
            index = biggest;
        }
    }
}
