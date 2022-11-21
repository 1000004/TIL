```HTML
<template>
  
</template>

<script>
  export default {
    data(){
      return{
        result: '',
      };
    },
    computed: { //일반데이터를 가공해서 쓸때 사용 (캐싱된 값이 사용됨 성능이 향상)
      
    },
    methods: {
      onClickButton(choice) {
      },
    },
    watch: { //감시하는 기능
      
    }
</script>
<!-- compent에만 적용 되도록 scoped -->
<style scoped>
  #computer {
    width: 142px;
    height: 200px;
    background-position: 0 0;
  }
</style>
```
* vue의 성능 최적화 중요
