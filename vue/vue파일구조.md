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
* 최대한 watch를 쓰지 않는다 (남용 하면 제어가 어렵다., 무한 반복이 일어 날 수 있다.)
* computed와 watch
  * watch는 data나 props가 변경되면 동작 수행
  * computed는 data나 props가 변경되면 새로운 값을 반환
