var vm=new Vue({
    el:"#app",
    data:{
        city:"",
        forecast:[],
    },
    methods:{
        search:function(){
            var that=this;
            axios.get("http://wthrcdn.etouch.cn/weather_mini?city="+that.city)
            .then(function(response){
                // console.log(response.data.data.forecast);
                that.forecast=response.data.data.forecast;
                console.log(that.forecast);
            })
            .catch(function(err){
                console.log(err);
            })
        },
        change:function(city){
            this.city=city;
            this.search();
        }
    }
})