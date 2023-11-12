package com.luoxinxin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        String[] priceStr = scanner.nextLine().substring(1).split(",");
        int[] price = new int[priceStr.length];
        for (int i = 0; i < priceStr.length; i++) {
            price[i] = Integer.parseInt(priceStr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, amount, price, res);

        System.out.println(res);
    }

    private static void dfs(int index, List<Integer> path, int cur, int amount, int[] price, List<List<Integer>> res) {
        if (cur >= amount || index >= price.length) {
            if (cur == amount) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        dfs(index + 1, path, cur, amount, price, res);
        path.add(price[index]);
        dfs(index, path, cur + price[index], amount, price, res);
        path.remove(path.size() - 1);
    }
}
