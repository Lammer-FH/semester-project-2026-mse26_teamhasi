export default {
  api: {
    input: {
        target: "./api-docs.json"
    },
    output: {
      target: "./src/generated/api.ts",
      schemas: "./src/generated/model",
      client: "axios",
    },
  },
};
