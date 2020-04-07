var vm=new Vue({
    el:"#app",
    data:{
        music:"",
        playList:[],
        playUrl:"",
        mvUrl:"",
        photoUrl:"",
        comment:[],
        isPlaying:false,

    },
    methods: {
        search:function(){
            var that=this;
            axios.get("https://autumnfish.cn/search?keywords="+that.music)
            .then(function(response){
                console.log(response);
                that.playList=response.data.result.songs;
            },
            function(err){
                console.log(err);
            })
        },
        play:function(musicId){
            var that=this;
            axios.get("https://autumnfish.cn/song/url?id="+musicId)
            .then(function(response){
                console.log(response.data.data[0].url);
                that.playUrl=response.data.data[0].url;
            },
            function(err){})

            axios.get("https://autumnfish.cn/song/detail?ids="+musicId)
            .then(function(response){
                console.log(response.data.songs[0].al.picUrl);
                that.photoUrl=response.data.songs[0].al.picUrl;
            },
            function(err){})

            axios.get("https://autumnfish.cn/comment/hot?type=0&id="+musicId)
            .then(function(response){
                console.log(response);
                that.comment=response.data.hotComments;
            })
        },
        playing:function(){
            console.log("play");
            this.isPlaying=true;
        },
        pause:function(){
            console.log("pause");
            this.isPlaying=false;
        },
        mvPlay:function(mvid){
            var that=this;
            axios.get("https://autumnfish.cn/mv/url?id="+mvid)
            .then(function(response){
                // console.log(response.data.data.url);
                that.mvUrl=response.data.data.url;
                console.log(that.mvUrl);
            },
            function(err){})
        }
            

    }
})