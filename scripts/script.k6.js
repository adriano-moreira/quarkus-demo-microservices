import http from 'k6/http'
import {check, sleep} from 'k6'

const testId = __ENV.TEST_ID; //load-test stress-test breackpoint-test
const testType = __ENV.TEST_TYPE; //load-test stress-test breackpoint-test
const vus = __ENV.TEST_TYPE === 'load-test' ? 1 : 60
const duration = __ENV.TEST_FAST === 'true' ? '10s' : '60s'
const runtime = __ENV.RUNTIME //jvm native
const concurrencyType = __ENV.C_TYPE
const testScenario = __ENV.TEST_SCENARIO
const port = runtime === 'jvm' ? '9001' : '9003'
const url = `http://localhost:${port}/${concurrencyType}/use/${testScenario}`

export const options = {
    vus: vus,
    duration: duration,
}

function request() {
    const resp = http.get(url)

    check(resp, {
        'should return 200': (r) => r.status === 200
    })
}

//small warm-up
export function setup() {
    for (let i = 0; i < 10; i++) {
        request()
    }
    sleep(.2)
}

export default function () {
    request()
    // if (testType === 'load-test') {
    //     sleep(1)
    // }
}

//export summary to json
export function handleSummary(data) {
    const outFile = `./reports/${testId}/k6-summary/${testType}-${runtime}-${concurrencyType}-${testScenario}.json`
    return {
        [outFile]: JSON.stringify(data, null, 4),
    }
}