package com.luoxinxin.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class solution1 {
    public static void main(String[] args) {
        solution1 solution = new solution1();
        int num = 5;
        int[][] pre = new int[][]{{0,4}, {1,2}, {1,3}, {2,3},{2,4}};
        solution.findOrder(num, pre);
    }
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;
    int mas = 0;
    List<Integer> res = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for(int i = 0; i< numCourses; i++){
            traverse(graph, i);
        }
        Collections.reverse(res);
        int[] res1 = new int[numCourses];
        for(int i = 0; i< numCourses; i++){
            res1[i] = res.get(i);
        }
        System.out.println(mas);
        return res1;
    }

    public void traverse(List<Integer>[] graph, int s){
        //base case
        if(onPath[s]){
            hasCycle = true;
        }
        if(hasCycle || visited[s]){
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        int max = 1;
        for(int e : graph[s]){
            max++;
            traverse(graph, e);
        }
        mas = Math.max(max, max);
        res.add(s);
        onPath[s] = false;
    }
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i< numCourses; i++){
            graph[i] = new LinkedList();
        }
        for(int[] e : prerequisites){
            int from = e[1];
            int to = e[0];
            graph[from].add(to);
        }
        return graph;
    }
}
