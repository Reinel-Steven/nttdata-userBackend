module.exports = function(config) {
  config.set({
    frameworks: ['jasmine'],
    files: [
      'src/test.ts' // Asegúrate de que esta ruta sea correcta
    ],
    preprocessors: {
      'src/test.ts': ['coverage']
    },
    reporters: ['progress', 'kjhtml', 'coverage'],
    coverageReporter: {
      dir: 'coverage/',
      reporters: [
        { type: 'html' },
        { type: 'text-summary' }
      ]
    },
    browsers: ['FirefoxHeadless'],

    captureTimeout: 60000,
    client: {
      jasmine: {
        random: false
      },
      clearContext: false
    },
    singleRun: true,
    logLevel: config.LOG_INFO,
    port: 9876,
    concurrency: Infinity
  });
};
