export default {
  api: {
    input: {
        target: "./openapi.json"
    },
    output: {
      target: "./src/generated/api.ts",
      schemas: "./src/generated/model",
      client: "axios",
    },
  },
};
