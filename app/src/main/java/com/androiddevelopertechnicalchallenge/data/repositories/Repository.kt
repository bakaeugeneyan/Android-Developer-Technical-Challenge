package com.androiddevelopertechnicalchallenge.data.repositories

import com.androiddevelopertechnicalchallenge.data.localdatasources.LocalDataSource
import com.androiddevelopertechnicalchallenge.data.remotedatasources.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localDataSource
}