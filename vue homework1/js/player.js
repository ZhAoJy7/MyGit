var vm=new Vue({
    el:"#app",
    data:{
        music:"",
        playList:[],

    },
    methods: {
        search:function(){
            var that=this;
            axios.get("https://autumnfish.cn/search?keywords="+that.music)
            .then(function(response){
                console.log(response.data.result.songs);
                that.playList=response.data.result.songs;
            },
            function(err){
                console.log(err);
            })
        }
    }
})