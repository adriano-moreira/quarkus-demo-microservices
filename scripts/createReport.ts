import * as fs from 'fs'

const testId = process.env.TEST_ID ?? 'without-test-id'
const testFast = process.env.TEST_FAST == 'true'

const paddingStart = 12

const testTypes = [
    'load-test',
    'stress-test',
    // 'breackpoint-test'
];
const concurrencyTypes = [
    'worker-thread',
    'io-thread',
    'virtual-thread'
];
const runtimes = [
    'jvm',
    'native',
];
const scenarioTests = [
    // 'nothing',
    'rest-client',
    'database-fast',
    'database-slow',
    'redis',
    // 'mix',
];

const time = testFast ? 10 : 60;


function betterDescription(string: string): string {
    if (string == 'worker-thread') {
        return 'default'
    }
    if (string == 'io-thread') {
        return 'reactive'
    }
    return string;
}

function padding(s: string) {
    return s.padStart(paddingStart, ' ');
}

for (let testType of testTypes) {

    const outputFile = `../reports/${testId}/${testType}-${time}s.md`;
    if (fs.existsSync(outputFile)) {
        fs.rmSync(outputFile)
    }

    writeln('# Report')
    // writeln(`teste executando no K6 simulando ${vu} usuarios por ${time} segundos`)

    for (let scenarioTest of scenarioTests) {
        writeln(`\n\n## GET .../use/${scenarioTest}`)
        writeFile(`_${scenarioTest}.md`)

        const header = '||' + concurrencyTypes.map(betterDescription).join('|') + '|';
        const separator = '|:-|-:|-:|-:|'

        writeln('### Throughput - Maior valor é melhor')
        // writeln('k6 -> summary.metrics.http_reqs.values.rate')
        writeln(header)
        writeln(separator)
        for (let runtime of runtimes) {
            write('|' + padding(runtime) + '|')
            for (let concurrencyType of concurrencyTypes) {
                const summary = readSummary(testId, testType, runtime, concurrencyType, scenarioTest)
                write(padding(numberFormat((summary?.metrics.http_reqs.values.count ?? 0 / time)) + ' req/seg'))
                write('|')
            }
            writeln('')
        }


        writeln('### Latency - Menor valor é melhor')
        // writeln('`k6 -> summary.metrics.http_req_duration`');
        writeln(header)
        writeln(separator)
        for (let runtime of runtimes) {
            write('|' + runtime + '(p90)|')
            for (let concurrencyType of concurrencyTypes) {
                const summary = readSummary(testId, testType, runtime, concurrencyType, scenarioTest)
                write(formatTime(summary?.metrics.http_req_duration.values['p(90)'] ?? 0))
                write('|')
            }
            writeln('')
            write('|' + padding(runtime + '(p99)') + '|')
            for (let concurrencyType of concurrencyTypes) {
                const summary = readSummary(testId, testType, runtime, concurrencyType, scenarioTest)
                write(formatTime(summary?.metrics.http_req_duration.values['p(99)'] ?? 0))
                write('|')
            }
            writeln('')
        }
        writeln('')

    }

    function writeln(content: string) {
        fs.appendFileSync(outputFile, content + '\n')
    }

    function write(content: string) {
        fs.appendFileSync(outputFile, content)
    }


    function writeFile(path: string) {
        if (fs.existsSync(path)) {
            const file = fs.readFileSync(path);
            fs.appendFileSync(outputFile, file.toString())
        }
    }
}

function numberFormat(n: number): string {
    return new Intl.NumberFormat('pt-BR', {}).format(n);
}

function formatTime(n: number): string {
    if (n > 1) {
        return (n.toFixed(0).toString() + 'ms').padStart(paddingStart, ' ');
    }
    return (n * 1000.0).toFixed(0).toString() + 'µs';
}


function readSummary(testId: string, testType: string, runtime: string, concurrencyType: string, testScenario: string): any | undefined {
    const k6SummeryFile = `../reports/${testId}/k6-summary/${testType}-${runtime}-${concurrencyType}-${testScenario}.json`
    if (fs.existsSync(k6SummeryFile)) {
        try {
            return JSON.parse(fs.readFileSync(k6SummeryFile).toString());
        } catch (e) {
            console.error(`ERROR: reading ${k6SummeryFile}`, e)
        }
    } else {
        console.warn(`WARN: file not found: ${k6SummeryFile}`)
    }
}