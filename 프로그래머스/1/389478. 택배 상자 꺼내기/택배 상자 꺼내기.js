function solution(n, w, num) {
    let answer = 0;
    let boxStorage = Array.from(
      { length: Math.ceil(n / w) },
      () => Array(w).fill(0)
    );
    let boxRow = -1;
    for (let i=1; i<=n; i++) {
        let row = ~~((i - 1) / w) % 2 ? (i % w ? w - (i % w) : 0) : (i - 1) % w;
        if (i == num) {
            boxRow = row;
        }
        if (boxRow==row) {
            answer++;
        }
    }
    return answer;
}