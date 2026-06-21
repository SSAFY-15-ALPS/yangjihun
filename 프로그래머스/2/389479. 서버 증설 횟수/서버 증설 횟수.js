function addServer(start, end, count, server) {
    for (let i=start; i<end; i++) {
        server[i] += count;
    }
    return;
}

function solution(players, m, k) {
    let answer = 0;
    let server = Array(24).fill(1); // default 서버 개수는 1개
    for (let i=0; i<24; i++) {
        if (players[i] >= (m * server[i])) { // 서버 * m 보다 사용자가 많으면
            let need = Math.ceil((players[i] + 1) / m) - server[i];
            answer += need;
            addServer(i, i+k, need, server);
        }
    }
    return answer;
}