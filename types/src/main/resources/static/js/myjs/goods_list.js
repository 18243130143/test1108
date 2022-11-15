new Vue({
    el:'#goodslist',
    data:{
        list:[],
        pageInfo:{},
        pageNum:1,
        pageSize:2,
        searchEntity:{}
    },
    methods:{
        paging:function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAllConnAndPage();
        },
        findAllConnAndPage:function(){
            var _this = this;
            var url = '../goods/findAllConnAndPage?pageNum='+this.pageNum+"&pageSize="+this.pageSize;
            axios.post(url,_this.searchEntity).then(function (response) {
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
                _this.pageSize = response.data.pageSize;
                _this.pageInfo = response.data;
            });
        }

    },
    created(){
        this.findAllConnAndPage();
    }
});