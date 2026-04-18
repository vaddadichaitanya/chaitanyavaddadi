import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '1m', target: 1000 }, // Ramp up
    { duration: '3m', target: 10000 }, // Peak load
    { duration: '1m', target: 0 }, // Ramp down
  ],
  thresholds: {
    http_req_duration: ['p(99)<200'], // 99% of requests must complete below 200ms
  },
};

export default function () {
  const res = http.post('https://api.example.com/v1/charges', JSON.stringify({ amount: 1000, currency: 'usd' }), { headers: { 'Content-Type': 'application/json' } });
  check(res, { 'status was 200': (r) => r.status == 200 });
  sleep(1);
}
