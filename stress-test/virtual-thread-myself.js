


import http from 'k6/http'
import {check} from 'k6'

export const options = {
    vus: 30,
    //iterations: 1,
    duration: '30s',
}

export default function() {
    const url = 'http://localhost:9001/virtual-thread/myself'

    const resp = http.get(url)
  
    //console.log(resp.body)
    
    check(resp, {
        'should return 200': (r) => r.status === 200
    })
}