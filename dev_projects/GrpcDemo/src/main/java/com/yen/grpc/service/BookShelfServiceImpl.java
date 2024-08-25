package com.yen.grpc.service;

import com.yen.grpc.BookShelfServiceGrpc;
import com.yen.grpc.BookShelfServiceProto;
import io.grpc.stub.StreamObserver;

public class BookShelfServiceImpl extends BookShelfServiceGrpc.BookShelfServiceImplBase{

    @Override
    public void listBookShelfs(BookShelfServiceProto.Empty2 request, StreamObserver<BookShelfServiceProto.BookShelfListResponse> responseObserver) {

        // TODO : implement
        System.out.println(">>> listBookShelfs start");
        //super.listBookShelfs(request, responseObserver);
    }

    @Override
    public void getBookShelfById(BookShelfServiceProto.ReturnBookShelfRequest request, StreamObserver<BookShelfServiceProto.ReturnBookShelfResponse> responseObserver) {

        // TODO : implement
        System.out.println(">>> getBookShelfById start");
        System.out.println(">>> getBookShelfById request = " + request);
        //super.getBookShelfById(request, responseObserver);

        BookShelfServiceProto.ReturnBookShelfResponse response = null;
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
