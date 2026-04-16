class Solution {
    public int mostBooked(int n, int[][] arr) {
        PriorityQueue<Integer> availRooms = new PriorityQueue<>();
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        int res[] = new int[n];

        for(int i=0;i<n;i++) availRooms.offer(i);

        // room, startTime, endTime
        PriorityQueue<int []> allocatedRooms = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        int index = 0;
        int time = 0;

        while(index < arr.length) {
            int start = arr[index][0];
            int end = arr[index][1];

            // System.out.println("Iteration: ");
            // free up all the rooms at current time
            while(!allocatedRooms.isEmpty() && allocatedRooms.peek()[2] <= time) {
                int freedRoom[] = allocatedRooms.poll();
                availRooms.offer(freedRoom[0]);
            }

            // check possibility of allocation for current room
            if(start <= time) { // its' eligible
                if(availRooms.size() > 0) { // bandwidth is there
                    int room = availRooms.poll(); // get the smallest room id
                    allocatedRooms.offer(new int[]{room, time, (time+(end-start))});
                    // System.out.println("\tindex : "+index+", room is allocated, room : "+room+", startTime : "+time+" endTime : "+(time + (end-start)));
                    res[room]++;
                    index++;
                } 
                else {
                    time = allocatedRooms.peek()[2];
                }
            }
            else {
                time = start;
                if(allocatedRooms.size() > 0) 
                    time = Math.min(time, allocatedRooms.peek()[2]);
            }
            // System.out.println("\t time : "+time+", availRooms : "+availRooms.size());
        }
    
        // System.out.println("res : "+Arrays.toString(res));
        int resRoom = 0;
        for(int i=1;i<n;i++) {
            if(res[i] > res[resRoom]) {
                resRoom = i;
            }
        }
        return resRoom;
    }
}
/*
rooms : 
    0 : 0
    1 : 0

n = 3

time = 0
index : [1,20] => time = 1;
availRooms : {0,1}
allocatedRooms : {(0, 1, 20)}

index++ : 
index : [2,10] => time = 2;


at a time : 
    1. the rooms getting freed at that time 
    2. rooms that we can allocate

edgecases : 
    time < arr[index].start => time = arr[index].start

res=> 0: 0
      1: 0

time = 0
index : 
    avail : {0,1}
    allocated : {}

    while(rooms are getting freed) => free them 
    while(pq.peek().end <= time) {
        free room pq.poll()
        res[room]++; // maintain at assign level
        avail.add(room);
    }

    if arr[index].start <= time {
        allocate room if free any
    }
    else {
        time = arr[index].start;
    }



*/