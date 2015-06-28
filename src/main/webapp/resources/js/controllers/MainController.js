/**
 * Created by msjo on 6/16/2015.
 */
app.controller('MainController', ['$scope',
    //function($scope){
    //    $scope.title = 'New arrival';
    //    $scope.promo = 'New 50% sale!';
    //    //$scope.product = {
    //    //    name: 'The Book of Trees',
    //    //    price: 19,
    //    //    pubdate: new Date('2014', '03', '08')
    //    //}
    //
    //    $scope.products = [
    //        {
    //            name: 'The Book of Trees',
    //            price: 19,
    //            pubdate: new Date('2014', '03', '08'),
    //            cover: 'resources/imgages/the-book-of-trees.jpg',
    //            likes: 0,
    //            dislikes: 0
    //        },
    //        {
    //            name: 'Program or be Programmed',
    //            price: 8,
    //            pubdate: new Date('2013', '08', '01'),
    //            cover: 'resources/imgages/program-or-be-programmed.jpg',
    //            likes: 0,
    //            dislikes: 0
    //        }
    //    ]
    //
    //    $scope.plusOne=function(index){
    //        $scope.products[index].likes += 1;
    //    };
    //    $scope.minusOne=function(index){
    //        $scope.products[index].dislikes += 1;
    //    };

    function ($scope) {

        //$scope.data = {
        //    id: 1,
        //    title: 'Foo',
        //    desc: 'More stuff about this here',
        //    category_name: 'Category 1'
        //};

        $scope.products = [
            {
                id: 1,
                title: 'Foo',
                desc: 'More stuff about this here',
                category_name: 'Category 1'
            },
            {
                id: 2,
                title: 'Goo',
                desc: 'More stuff about this here',
                category_name: 'Category 2'
            },
            {
                id: 3,
                title: 'Roo',
                desc: 'Blah details on Roo are here',
                category_name: 'Category 1'
            },
            {
                id: 4, title: 'Hoo',
                desc: 'More stuff about Hoo here',
                category_name: 'Category 2'
            },
            {
                id: 5, title: 'Woo',
                desc: 'More stuff about this here',
                category_name: 'Category 3'
            }
        ];

        $scope.setSelectedItem = function (product) {
            $scope.selectedItem = product.id;
        };

        $scope.deleteItem = function () {
            if ($scope.selectedItem >= 0) {
                $scope.data.splice($scope.selectedItem, 1);
            }
        };

    }]);