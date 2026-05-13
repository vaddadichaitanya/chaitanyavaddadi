module.exports = {
  default: {
    requireModule: ['ts-node/register'],
    require: ['src/support/*.ts', 'src/steps/*.ts'],
    format: ['summary', 'progress'],
    paths: ['src/features/**/*.feature'],
    publishQuiet: true
  }
};