package com.laopao.blog.controller;

/**
 * @Description:
 * @Title: ChatCode
 * @Package com.laopao.blog.controller
 * @Author: zhaozhiyong
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/5/1 16:59
 */
public class ChatCode {



        // 定义一个8x8的棋盘
        private int[][] board = new int[8][8];

        // 判断某个位置是否可以放置皇后
        private boolean canPlaceQueen(int row, int col) {
            // 检查列是否有皇后
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 1) {
                    return false;
                }
            }
            // 检查左上角是否有皇后
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            // 检查右上角是否有皇后
            for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }

        // 回溯求解八皇后问题
        private void solve(int row) {
            // 找到一个解
            if (row == 8) {
                printSolution();
            }
            // 尝试在该行的每个位置放置皇后
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    // 该位置可以放置皇后
                    board[row][col] = 1;
                    solve(row + 1);
                    board[row][col] = 0;
                }
            }
        }

        // 输出解决方案
        private void printSolution() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void main(String[] args) {
            ChatCode problem = new ChatCode();
            problem.solve(0);
        }


}
