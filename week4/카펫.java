class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int height = 1; height <= yellow / height; height++) {
            if (yellow % height != 0)
                continue;
            int width = yellow / height;
            if ((height + 2) * (width + 2) == brown + yellow) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        return answer;
    }
}
